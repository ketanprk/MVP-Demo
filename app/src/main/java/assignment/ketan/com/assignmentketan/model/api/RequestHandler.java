package assignment.ketan.com.assignmentketan.model.api;


import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class RequestHandler {

    String response;

    public enum RequestTypeTag {
        POST_REQUEST, GET_REQUEST;
    }

    public enum DataFormatTag {
        JSON_FORMAT, STRING_FORMAT, XML_FORMAT;
    }


    public String makeHttpUrlConnectionRequest(String requestURL, HashMap<String, String> postDataParams, JSONObject dataObject, RequestTypeTag requestType, DataFormatTag dataFormat, HashMap<String, String> headers) {

        URL url = null;
        String response = "";
        int responseCode = 0;
        String data = "";
        HttpURLConnection conn = null;
        try {


            if (requestType.equals(RequestTypeTag.POST_REQUEST)) {
                url = new URL(requestURL);
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("POST");
                if (headers != null) {
                    for (Map.Entry<String, String> entry : headers.entrySet()) {

                        conn.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                if (dataFormat.equals(DataFormatTag.JSON_FORMAT)) {
                    data = dataObject.toString();
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setRequestProperty("Accept", "*/*");
                } else {
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    conn.setRequestProperty("Accept", "*/*");
                    if (postDataParams != null)
                        data = getPostDataString(postDataParams);
                }
                conn.setDoInput(true);
                conn.setDoOutput(true);
                OutputStream os = conn.getOutputStream();
                OutputStreamWriter writer = new OutputStreamWriter(os);
                writer.write(data);
                writer.flush();
                writer.close();
                os.close();
            } else {

                if (postDataParams != null) {
                    String requestedUrl = requestURL + "?" + getPostDataString(postDataParams);
                    url = new URL(requestedUrl);


                } else {
                    url = new URL(requestURL);
                }

                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000);
                conn.setConnectTimeout(15000);
                if (headers != null) {
                    for (Map.Entry<String, String> entry : headers.entrySet()) {
                        conn.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                conn.setRequestMethod("GET");
            }

            responseCode = conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = br.readLine()) != null) {
                    response += line;
                }

                if (response.equals("")) {
                    response = "success";
                }
            } else if (responseCode == HttpsURLConnection.HTTP_NO_CONTENT) {
                response = "success";
            } else {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                while ((line = br.readLine()) != null) {
                    response += line;
                }

                response = "Error_Stream" + response;
            }

        } catch (Exception e) {
            response = e.getMessage();
        }

        return response;


    }

    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }


}
