package org.example.repository.cancellation;

import org.example.model.CancellationReason;

public interface CancellationReasonDAO {
    CancellationReason findCancellationReasonById(int reasonId);
}