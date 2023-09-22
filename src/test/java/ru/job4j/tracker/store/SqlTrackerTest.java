package ru.job4j.tracker.store;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveItemAndFindByNameThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item");
        Item item2 = new Item(777, "item");
        Item item3 = new Item(888, "item3");
        Item item4 = new Item("item4");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        List<Item> expect = tracker.findByName("item");
        assertThat(expect.size()).isEqualTo(2);
        assertThat(expect.get(0).getName()).isEqualTo(expect.get(1).getName());
    }

    @Test
    public void whenSaveItemAndFindAllThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item");
        Item item2 = new Item(777, "item");
        Item item3 = new Item(888, "item3");
        Item item4 = new Item("item4");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        List<Item> expect = tracker.findAll();
        assertThat(expect.size()).isEqualTo(4);
        assertThat(expect.get(0).getName()).isEqualTo("item");
        assertThat(expect.get(1).getName()).isEqualTo("item");
        assertThat(expect.get(2).getName()).isEqualTo("item3");
        assertThat(expect.get(3).getName()).isEqualTo("item4");
    }

    @Test
    public void whenSaveItemAndDeleteThenBoolean() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item(777, "item1");
        Item item2 = new Item(888, "item2");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.delete(item1.getId())).isTrue();
        assertThat(tracker.delete(item2.getId())).isTrue();
        assertThat(tracker.delete(item2.getId())).isFalse();
    }

    @Test
    public void whenSaveItemAndReplaceThenBoolean() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        assertThat(tracker.replace(item1.getId(), item2)).isTrue();
    }

    @Test
    public void whenSaveItemAndAddThenItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item expect = tracker.add(item1);
        assertThat(expect).isEqualTo(item1);
    }
}