package message;

public class HelloWorldDecoupled {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
		MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
		mr.setMessageProvider(mp);
		mr.render();
	}

}
