package com.example.wifi_info_in_korea;

import com.example.wifi_info_in_korea.DB.DBHandler;
import com.example.wifi_info_in_korea.DB.DBHistory;
import com.example.wifi_info_in_korea.dto.HistoryTableRow;
import com.example.wifi_info_in_korea.dto.TableRow;

import java.io.*;
import java.time.LocalDate;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "location", value="")
public class Location extends HttpServlet {
    private TableRow[] rows;

    public void init() {
        this.rows = null;
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String lat = request.getParameter("lat");
        String lnt = request.getParameter("lnt");

        if (lat != null && !lat.equals("") && lnt != null && !lnt.equals("")) {
            double LAT = Double.parseDouble(lat);
            double LNT = Double.parseDouble(lnt);
            DBHandler dbHandler = new DBHandler();
            DBHistory dbHistory = new DBHistory();
            LocalDate currentDate = LocalDate.now();
            HistoryTableRow historyTableRow = new HistoryTableRow("0", lat,lnt,currentDate.toString());
            dbHistory.addRow(historyTableRow);

            this.rows = dbHandler.wifi_table_dbSelect(LAT, LNT);
        }
        else{
            this.rows = null;
        }

        // Create a StringBuilder to hold the HTML content
        StringBuilder htmlContent = new StringBuilder();

        // Add the HTML content to the StringBuilder
        htmlContent.append("<html>");
        htmlContent.append("<head>");
        htmlContent.append("<title>WIFI info Seoul</title>");
        htmlContent.append("<script>");
        htmlContent.append("function updatePos() {");
        htmlContent.append("document.getElementById('LAT').value = 37.5544069;");
        htmlContent.append("document.getElementById('LNT').value = 126.8998666;");
        htmlContent.append("window.location.href = url + '?' + 'lat=' + lat + '&lnt=' + lnt;");
        htmlContent.append("}");
        htmlContent.append("</script>");
        htmlContent.append("<script>");
        htmlContent.append("function updateValue() {");
        htmlContent.append("const url = 'http://localhost:8080/';");
        htmlContent.append("const lat = document.getElementById('LAT').value;");
        htmlContent.append("const lnt = document.getElementById('LNT').value;");
        htmlContent.append("window.location.href = url + '?' + 'lat=' + lat + '&lnt=' + lnt;");
        htmlContent.append("}");
        htmlContent.append("</script>");
        htmlContent.append("<style>");
        htmlContent.append("table {");
        htmlContent.append("width: 100%;");
        htmlContent.append("border-collapse: collapse;");
        htmlContent.append("}");
        htmlContent.append("th, td {");
        htmlContent.append("padding: 8px;");
        htmlContent.append("text-align: left;");
        htmlContent.append("border-bottom: 1px solid #ddd;");
        htmlContent.append("}");
        htmlContent.append("th {");
        htmlContent.append("background-color: green;");
        htmlContent.append("color: white;");
        htmlContent.append("}");
        htmlContent.append("tr:nth-child(even) {");
        htmlContent.append("background-color: #f2f2f2;");
        htmlContent.append("}");
        htmlContent.append("</style>");
        htmlContent.append("</head>");
        htmlContent.append("<body>");
        htmlContent.append("<h1>와이파이 정보 구하기</h1>");
        htmlContent.append("<br/>");
        htmlContent.append("<a href=\".\">홈</a> |");
        htmlContent.append("<a href=\"/history.jsp\">위치 히스토리 목록</a> |");
        htmlContent.append("<a href=\"apiRequest\">Open API 와이파이 정보 가져오기</a> |");
        htmlContent.append("<br/>");
        htmlContent.append("<label for=\"LAT\" >LAT:</label>");
        if(lat == null){
            htmlContent.append("<input type=\"text\" id=\"LAT\" name=\"LAT\" value=\"0.0\">,");
        }
        else{
            htmlContent.append("<input type=\"text\" id=\"LAT\" name=\"LAT\" value=").append(lat).append(">,");
        }
        htmlContent.append("<label for=\"LNT\">LNT:</label>");
        if(lat == null){
            htmlContent.append("<input type=\"text\" id=\"LNT\" name=\"LNT\" value=\"0.0\">");
        }
        else{
            htmlContent.append("<input type=\"text\" id=\"LNT\" name=\"LNT\" value=").append(lnt).append(">");
        }
        htmlContent.append("<button type=\"button\" onclick=\"updatePos()\">내 위치 가져오기</button>");
        htmlContent.append("<button type=\"button\" onclick=\"updateValue()\">근처 WIPI 정보 가져오기</button>");
        htmlContent.append("<br/>");
        htmlContent.append("<table id=\"generatedTable\">");
        htmlContent.append("<thead>");
        htmlContent.append("<tr>");
        htmlContent.append("<th>거리(Km)</th>");
        htmlContent.append("<th>관리번호</th>");
        htmlContent.append("<th>자치구</th>");
        htmlContent.append("<th>와이파이명</th>");
        htmlContent.append("<th>도로명주소</th>");
        htmlContent.append("<th>상세주소</th>");
        htmlContent.append("<th>설치위치(층)</th>");
        htmlContent.append("<th>설치유형</th>");
        htmlContent.append("<th>설치기관</th>");
        htmlContent.append("<th>서비스 구분</th>");
        htmlContent.append("<th>망종류</th>");
        htmlContent.append("<th>설치년도</th>");
        htmlContent.append("<th>실내외구분</th>");
        htmlContent.append("<th>WIFI접속한경</th>");
        htmlContent.append("<th>X좌표</th>");
        htmlContent.append("<th>Y좌표</th>");
        htmlContent.append("<th>작업일자</th>");
        htmlContent.append("</tr>");
        htmlContent.append("</thead>");
        htmlContent.append("<tbody id=\"tableBody\">");
        if(this.rows != null){
            for(TableRow row : rows){
                htmlContent.append("<tr>");
                htmlContent.append("<td>").append(row.DISTANCE).append("</td>");
                htmlContent.append("<td>").append(row.X_SWIFI_MGR_NO).append("</td>");
                htmlContent.append("<td>").append(row.X_SWIFI_WRDOFC).append("</td>");
                htmlContent.append("<td>").append(row.X_SWIFI_MAIN_NM).append("</td>");
                htmlContent.append("<td>").append(row.X_SWIFI_ADRES1).append("</td>");
                htmlContent.append("<td>").append(row.X_SWIFI_ADRES2).append("</td>");
                htmlContent.append("<td>").append(row.X_SWIFI_INSTL_FLOOR).append("</td>");
                htmlContent.append("<td>").append(row.X_SWIFI_INSTL_TY).append("</td>");
                htmlContent.append("<td>").append(row.X_SWIFI_INSTL_MBY).append("</td>");
                htmlContent.append("<td>").append(row.X_SWIFI_SVC_SE).append("</td>");
                htmlContent.append("<td>").append(row.X_SWIFI_CMCWR).append("</td>");
                htmlContent.append("<td>").append(row.X_SWIFI_CNSTC_YEAR).append("</td>");
                htmlContent.append("<td>").append(row.X_SWIFI_INOUT_DOOR).append("</td>");
                htmlContent.append("<td>").append(row.X_SWIFI_REMARS3).append("</td>");
                htmlContent.append("<td>").append(row.LAT).append("</td>");
                htmlContent.append("<td>").append(row.LNT).append("</td>");
                htmlContent.append("<td>").append(row.WORK_DTTM).append("</td>");
                htmlContent.append("</tr>");
            }
        }

        htmlContent.append("</tbody>");
        htmlContent.append("</table>");
        htmlContent.append("</body>");
        htmlContent.append("</html>");
        // Hello
        PrintWriter out = response.getWriter();
        out.println(htmlContent.toString());
    }

    public void destroy() {
    }
}