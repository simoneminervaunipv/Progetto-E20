package server.FakeClient.tests;

import it.unipv.ingsw.progettoe20.server.Protocol;
import it.unipv.ingsw.progettoe20.server.database.DatabaseManager;
import server.FakeClient.utils.FailedTestException;
import server.FakeClient.utils.TestConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class GenidTest {
    private BufferedReader in;
    private PrintWriter out;
    private DatabaseManager dbManager;

    public GenidTest(BufferedReader in, PrintWriter out, DatabaseManager dbManager) {
        this.in = in;
        this.out = out;
        this.dbManager = dbManager;
    }

    public void test() throws FailedTestException {
        String  result;

        System.out.println(String.format(TestConstants.TEST_TITLE, Protocol.REQUEST_GENERATE_ID.toUpperCase()));
        out.println(Protocol.REQUEST_GENERATE_ID);

        try {
            result = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Check correct response format
        String[] parts = result.split(Protocol.SEPARATOR);
        if (parts.length != 2) {
            throw new FailedTestException("expected '" + Protocol.RESPONSE_OK + ":ID' got '" + result + "'");
        }

        // Check DB changes
        try {
            dbManager.checkID(parts[1]);
        } catch (IllegalArgumentException ie) {
            throw new FailedTestException("generated ID '" + parts[1] + "' not found in DB");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(TestConstants.TEST_SUCCESS);
    }
}