package com.example.wifi_info_in_korea;

import com.example.wifi_info_in_korea.DB.DBHandler;
import com.example.wifi_info_in_korea.dto.TbPublicWifiInfo;
import com.example.wifi_info_in_korea.dto.Row;
import com.example.wifi_info_in_korea.dto.WifiJsonData;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet(name = "apiRequest", value = "/apiRequest")
public class fetchData extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int startIndex = 1;
        DBHandler dbHandler = new DBHandler();
        dbHandler.wifiInfoDeleteAll();

        while(startIndex <= 10000) {
            String apiUrl = String.format("http://openapi.seoul.go.kr:8088/6c7a534c726a756e37316d59417a59/json/TbPublicWifiInfo/%d/%d/",
                    startIndex, startIndex+999);
            try {
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder str = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        str.append(line);
                    }
                    reader.close();

                    connection.disconnect();
                    Gson gson = new Gson();
                    WifiJsonData obj = gson.fromJson(str.toString(), WifiJsonData.class);
                    TbPublicWifiInfo TbPublicWifiInfo = obj.TbPublicWifiInfo;
                    Row[] rowArr = TbPublicWifiInfo.row;

                    for (Row r : rowArr) {
                        dbHandler.wifiInfoInsert(r);
                    }
                } else {
                    // Handle errors here
                    response.sendError(responseCode, "API Request Failed");
                }

                // Close the connection
                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
            }
            startIndex += 1000;
        }

        int count = dbHandler.countWifiInfo();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<div style=\"text-align: center;\">"); // Center-align the content
        out.println("<h1>" + count + "개의 WIFI 정보를 정상적으로 저장하였습니다.</h1>");
        out.println("<h3><a href=\".\">홈으로 가기</a></h3>"); // Replace your_home_url with the actual URL
        out.println("</div>");
        out.println("</body></html>");
    }
}
