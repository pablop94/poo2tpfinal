package interfaces;

public interface MailServer {

	void sendMail(String destinationAddress, String subject, String body);

}
