<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%--<html>--%>
<%--<head>--%>
<%--    <title>WIFI info Seoul</title>--%>
<%--    <script>--%>
<%--        function updateValue() {--%>
<%--            const url = 'http://localhost:8080';--%>
<%--            const lat = document.getElementById('LAT').value;--%>
<%--            const lnt = document.getElementById('LNT').value;--%>

<%--            const dataToSend = {--%>
<%--                LAT: lat,--%>
<%--                LNT: lnt--%>
<%--            };--%>

<%--            const requestOptions = {--%>
<%--                method: 'POST',--%>
<%--                headers: {--%>
<%--                    'Content-Type': 'application/json',--%>
<%--                },--%>
<%--                body: JSON.stringify(dataToSend), // Convert the data to JSON format--%>
<%--            };--%>

<%--            // Use fetch() to send the POST request--%>
<%--            fetch(url, requestOptions)--%>
<%--                .then(response => {--%>
<%--                    if (!response.ok) {--%>
<%--                        throw new Error('Network response was not ok');--%>
<%--                    }--%>
<%--                    return response.json();--%>
<%--                })--%>
<%--                .then(data => {--%>
<%--                })--%>
<%--                .catch(error => {--%>
<%--                    // Handle errors--%>
<%--                    console.error('Fetch error:', error);--%>
<%--                })--%>
<%--        }--%>
<%--    </script>--%>
<%--    <script>--%>
<%--        function updateValue() {--%>
<%--            const url = 'http://localhost:8080/';--%>
<%--            const lat = document.getElementById('LAT').value;--%>
<%--            const lnt = document.getElementById('LNT').value;--%>
<%--            window.location.href = url + "?" + "lat=" + lat + "&lnt=" + lnt;--%>
<%--        }--%>
<%--    </script>--%>
<%--    <style>--%>
<%--        table {--%>
<%--            width: 100%;--%>
<%--            border-collapse: collapse;--%>
<%--        }--%>

<%--        th, td {--%>
<%--            padding: 8px;--%>
<%--            text-align: left;--%>
<%--            border-bottom: 1px solid #ddd;--%>
<%--        }--%>

<%--        th {--%>
<%--            background-color: green;--%>
<%--            color: white;--%>
<%--        }--%>

<%--        tr:nth-child(even) {--%>
<%--            background-color: #f2f2f2;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1><%= "와이파이 정보 구하기" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">홈</a> |--%>
<%--<a href="hello-servlet">위치 히스토리 목록</a> |--%>
<%--<a href="apiRequest">Open API 와이파이 정보 가져오기</a> |--%>
<%--<a href="hello-servlet">즐겨 찾기 보기</a> |--%>
<%--<a href="hello-servlet">즐겨찾기 그룹 관리</a>--%>
<%--<br/>--%>

<%--<label for="LAT" >LAT:</label>--%>
<%--<input type="text" id="LAT" name="LAT">,--%>
<%--<label for="LNT">LNT:</label>--%>
<%--<input type="text" id="LNT" name="LNT">--%>

<%--<button type="button">내 위치 가져오기</button>--%>
<%--<button type="button" onclick={updateValue()}>근처 WIPI 정보 가져오기</button>--%>
<%--<br/>--%>

<%--<table id="generatedTable">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>거리(Km)</th>--%>
<%--        <th>관리번호</th>--%>
<%--        <th>자치구</th>--%>
<%--        <th>와이파이명</th>--%>
<%--        <th>도로명주소</th>--%>
<%--        <th>상세주소</th>--%>
<%--        <th>설치위치(층)</th>--%>
<%--        <th>설치유형</th>--%>
<%--        <th>설치기관</th>--%>
<%--        <th>서비스 구분</th>--%>
<%--        <th>망종류</th>--%>
<%--        <th>설치년도</th>--%>
<%--        <th>실내외구분</th>--%>
<%--        <th>WIFI접속한경</th>--%>
<%--        <th>X좌표</th>--%>
<%--        <th>Y좌표</th>--%>
<%--        <th>작업일자</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody id="tableBody">--%>
<%--    <!-- Table rows will be inserted here -->--%>
<%--    </tbody>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>