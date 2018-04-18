package com.example.myversionofsqlitedatabase;

/**
 * Created by tom on 7/5/2016.
 */
public class ChatProvider {

    private String chat;


    public ChatProvider(String chat)
    {
        this.chat = chat;

    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }
}
