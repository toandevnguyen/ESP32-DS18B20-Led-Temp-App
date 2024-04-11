package com.toan.devnguyen.iots.tdmu.remoteled;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import org.eclipse.paho.mqttv5.client.IMqttToken;
import org.eclipse.paho.mqttv5.client.MqttAsyncClient;
import org.eclipse.paho.mqttv5.client.MqttCallback;
import org.eclipse.paho.mqttv5.client.MqttConnectionOptions;
import org.eclipse.paho.mqttv5.client.MqttDisconnectResponse;
import org.eclipse.paho.mqttv5.client.persist.MemoryPersistence;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.eclipse.paho.mqttv5.common.MqttMessage;
import org.eclipse.paho.mqttv5.common.packet.MqttProperties;

public class MainActivity extends AppCompatActivity {
    SwitchCompat switchRemoteLed;
    ImageView imageLightOn;
    ImageView imageLightOff;
    TextView temperatureTextView;

    private boolean isLightOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchRemoteLed = findViewById(R.id.switchRemoteLed);
        imageLightOff = findViewById(R.id.imgOffLed);
        imageLightOn = findViewById(R.id.imgOnLed);
        temperatureTextView = findViewById(R.id.txtTemperature);

        switchRemoteLed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (compoundButton.isChecked()) {
                    toggleLight();
                    controlLightOnESP32(isLightOn);
                } else {
                    toggleLight();
                    controlLightOnESP32(isLightOn);
                }
            }
        });

    }

    private void toggleLight() {
        //Nếu Đèn đang bật, sẽ tắt đèn

        if (isLightOn) {
//            imageLightOff.setImageResource(R.drawable.led_bulb_off);
            imageLightOn.setVisibility(View.INVISIBLE);
            switchRemoteLed.setText("Off         ");
            isLightOn = false;
        } else {
            //Nếu Đèn đang tắt, sẽ bật đèn
            imageLightOn.setVisibility(View.VISIBLE);
            switchRemoteLed.setText("On          ");
            isLightOn = true;
        }
    }

    private void controlLightOnESP32(boolean isOn) {
        String topic = "Đèn";
        String topic_2 = "sensor/temperature-DS18B20"; //đường dẫn đến topic
        String content = isOn ? "1" : "0";
        int qos = 0;
        String broker = "tcp://34.122.33.220";//ip máy ảo VPS mà bạn đã đăng ký trên GG Cloud

        String clientId = "Redmi Note 10s"; //ID điện thoại

        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttConnectionOptions connOpts = new MqttConnectionOptions();
            connOpts.setCleanStart(false);

            MqttAsyncClient sampleClient = new MqttAsyncClient(broker, clientId, persistence);

            sampleClient.setCallback((new MqttCallback() {
                @Override
                public void disconnected(MqttDisconnectResponse disconnectResponse) {

                }

                @Override
                public void mqttErrorOccurred(MqttException exception) {

                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    if (topic.equals(topic_2)) {
                        String temperature = new String(message.getPayload());
                        temperatureTextView.setText(temperature);
                    }

                }

                @Override
                public void deliveryComplete(IMqttToken token) {

                }

                @Override
                public void connectComplete(boolean reconnect, String serverURI) {

                }

                @Override
                public void authPacketArrived(int reasonCode, MqttProperties properties) {

                }
            }));

            System.out.println("Connecting to broker: " + broker);


            IMqttToken token = sampleClient.connect(connOpts);

            token.waitForCompletion();
            System.out.println("Connected");

            sampleClient.subscribe(topic_2, 0);


            System.out.println("Publishing message: " + content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            token = sampleClient.publish(topic, message);
            token.waitForCompletion();

            System.out.println("Disconnected");
            System.out.println("Close client.");
            sampleClient.close();
            System.exit(0);
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }

    }

}

