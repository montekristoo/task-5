package org.example.repository.cancellation;

import org.example.exception.DatabaseConnectionException;
import org.example.model.CancellationReason;
import org.example.service.DatabaseExecutorService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Cebotari Viktor
 * @since 12.10.2023
 */
public class CancellationReasonDaoImpl implements CancellationReasonDAO {
    private final DatabaseExecutorService executorService;

    public CancellationReasonDaoImpl(Connection connection) {
        this.executorService = new DatabaseExecutorService(connection);
    }

    @Override
    public CancellationReason findCancellationReasonById(int reasonId) {
        String sql = "SELECT * FROM cancellation_reason WHERE reason_id = " + reasonId;
        return getCancellationReason(executorService.executeQuery(sql));
    }

    private CancellationReason getCancellationReason(ResultSet resultSet) {
        try {
            resultSet.next();
            CancellationReason reason = new CancellationReason();
            int reasonId = resultSet.getInt(1);
            String reasonText = resultSet.getString(2);
            reason.setReasonId(reasonId);
            reason.setReasonText(reasonText);
            return reason;
        } catch (SQLException e) {
            throw new DatabaseConnectionException(e.getMessage());
        }
    }

}