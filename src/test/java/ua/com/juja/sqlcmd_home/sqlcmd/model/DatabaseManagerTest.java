package sqlcmd_homework.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sims on 03.09.2015.
 */
public abstract class DatabaseManagerTest {
    private DatabaseManager manager;

    public abstract DatabaseManager getDatabaseManager();

    @Before
    public void setup(){
        manager = getDatabaseManager();
        manager.connect("mydb_home","postgres", "postgres");
    }

    @Test
    public void testGetAllTableNames(){
        String[] tableNames = manager.getTableNames();
        assertEquals("[user, test]", Arrays.toString(tableNames));
    }

    @Test
    public void testGetTableData(){
        //given
        manager.clear("user");
        //when
        // add new user
        DataSet input = new DataSet();
        input.put("name", "John");
        input.put("password", "pass");
        input.put("id", 13);

        manager.create("user", input);
        //then
        DataSet[] users = manager.getTableData("user");
        assertEquals(1, users.length);

        DataSet user = users[0];
        assertEquals("[name, password, id]", Arrays.toString(user.getNames()));
        assertEquals("[John, pass, 13]", Arrays.toString(user.getValues()));
    }

    @Test
    public void testUpdateTableData() {
        // given
        manager.clear("user");

        DataSet input = new DataSet();

        input.put("name", "Stiven");
        input.put("password", "pass");
        input.put("id", 13);

        manager.create("user", input);

        // when
        DataSet newValue = new DataSet();
        newValue.put("password", "pass2");
        newValue.put("name", "Pup");
        manager.update("user", 13, newValue);

        // then
        DataSet[] users = manager.getTableData("user");
        assertEquals(1, users.length);

        DataSet user = users[0];
        assertEquals("[name, password, id]", Arrays.toString(user.getNames()));
        assertEquals("[Pup, pass2, 13]", Arrays.toString(user.getValues()));
    }
    @Test
    public void testGetColumnNames() {
        // given
        manager.clear("user");

        // when
        String[] columnNames = manager.getTableColumns("user");

        //then
        assertEquals("[name, password, id]", Arrays.toString(columnNames));
    }

    @Test
    public void testIsConnected() {
        // given
        // when
        //then
        assertTrue(manager.isConnected());
    }
}