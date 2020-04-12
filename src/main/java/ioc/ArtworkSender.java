package ioc;

public interface ArtworkSender {
	void SendArtwork(String artworkPath, Recipient recipient);
	String getFriendlyName();
	String getShortName();
}
