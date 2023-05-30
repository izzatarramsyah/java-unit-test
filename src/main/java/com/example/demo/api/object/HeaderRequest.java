package com.example.demo.api.object;

public class HeaderRequest {
   
    private String session;
	private String uname;
	private String command;
	private String channel;
	
	public HeaderRequest() {}
	
	public HeaderRequest(String session,String uname, String command, String channel) {
		this.session=session;
		this.uname=uname;
		this.command = command;
		this.channel = channel;
	}

	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uName) {
		this.uname = uName;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	@Override
	public String toString() {
		return "MessageRequest [session=" + session + ", uname=" + uname + "command=" + command + ", channel=" + channel + " ]";
	}
}
