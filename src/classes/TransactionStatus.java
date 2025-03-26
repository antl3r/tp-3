package classes;

import java.util.Date;

public class TransactionStatus {
    private Date timestamp;
    private String status;

    public TransactionStatus(Date timestamp, String status) {
        this.timestamp = timestamp;
        setStatus(status);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status.equals("Sedang Dikemas") || status.equals("Menunggu Pengirim") ||
            status.equals("Sedang Dikirim") || status.equals("Pesanan Selesai") ||
            status.equals("Dikembalikan")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status");
        }
    }
}
