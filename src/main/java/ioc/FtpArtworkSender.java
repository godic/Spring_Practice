package ioc;

public class FtpArtworkSender implements ArtworkSender{
	@Override
	public void sendArtwork(String artworkPath, Recipient recipient) {
		 //ftp Logic
	}
	
	@Override
	public String getFriendlyName() {
		return "���� ���� ��������";
	}
	
	@Override
	public String getShortName() {
		return "ftp";
	}
}
