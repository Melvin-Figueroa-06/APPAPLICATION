package com.example.app_aplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatBoxActivity extends AppCompatActivity {

    public RecyclerView myRecylerView ;
    public List<Message> MessageList ;
    public ChatBoxAdapter chatBoxAdapter;
    public  EditText messagetxt ;
    public  Button send ;
    //declare socket object

    public String Nickname ;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_box);
/*
// get the nickame of the user
        messagetxt = (EditText) findViewById(R.id.message) ;
        send = (Button)findViewById(R.id.send);

        Nickname= (String)getIntent().getExtras().getString(Citas.NICKNAME);

        socket = IO.socket("http://172.21.0.1:3002");
        //create connection
        socket.connect();
// emit the event join along side with the nickname
        socket.emit("join",Nickname);

        } catch (URISyntaxException e) {
            e.printStackTrace();
         }

        MessageList = new ArrayList<>();
        myRecylerView = (RecyclerView) findViewById(R.id.messagelist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        myRecylerView.setLayoutManager(mLayoutManager);
        myRecylerView.setItemAnimator(new DefaultItemAnimator());



        // message send action
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //retrieve the nickname and the message content and fire the event messagedetection
                if(!messagetxt.getText().toString().isEmpty()){
                    socket.emit("messagedetection",Nickname,messagetxt.getText().toString());

                    messagetxt.setText(" ");
                }


            }
        });

   socket.on("userjoinedthechat", new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String data = (String) args[0];
                    // get the extra data from the fired event and display a toast
                    Toast.makeText(ChatBoxActivity.this,data,Toast.LENGTH_SHORT).show();

                }
            });
        }
*/
    }

   /*socket.on("userdisconnect", new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String data = (String) args[0];

                    Toast.makeText(ChatBoxActivity.this,data,Toast.LENGTH_SHORT).show();

                }
            });
        }
    });

   socket.on("message", new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    try {
                        //extract data from fired event

                        String nickname = data.getString("senderNickname");
                        String message = data.getString("message");

                        // make instance of message

                        Message m = new Message(nickname,message);


                        //add the message to the messageList

                        MessageList.add(m);

                        // add the new updated list to the adapter
                        chatBoxAdapter = new ChatBoxAdapter(MessageList);

                        // notify the adapter to update the recycler view

                        chatBoxAdapter.notifyDataSetChanged();

                        //set the adapter for the recycler view

                        myRecylerView.setAdapter(chatBoxAdapter);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            });
        }
    });
    }*/
  /*  @Override
    protected void onDestroy() {
        super.onDestroy();
        socket.disconnect();
    }
*/

}