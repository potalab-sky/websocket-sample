<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2021/04/06
  Time: 8:29 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>send binary</title>
    </head>
    <body>
        <form>
            <!-- 불러온 파일 정보를 나타내는 텍스트 박스 -->
            <input id="fileInfo" type="text" readonly>
            <input onclick="openFile()" id="fileLoad" value="load" type="button">
            <!-- 메시지 송신을 하는 버튼 -->
            <input onclick="sendMessage()" value="Send" type="button">
            <!-- WebSocket 접속 종료하는 버튼 -->
            <input onclick="disconnect()" value="Disconnect" type="button">
        </form>
        <!-- 콘솔 메시지의 역할을 하는 로그 텍스트 에리어.(수신 메시지도 표시한다.) -->
        <textarea id="messageTextArea" rows="10" cols="50"></textarea>
        <script type="text/javascript">
            // 「WebSocketEx」는 프로젝트 명
            // 「websocket」는 호스트 명
            // WebSocket 오브젝트 생성 (자동으로 접속 시작한다. - onopen 함수 호출)
            var webSocket = new WebSocket("ws://localhost:8080/binary");
            // 콘솔 텍스트 에리어 오브젝트
            var messageTextArea = document.getElementById("messageTextArea");
            // WebSocket 서버와 접속이 되면 호출되는 함수
            webSocket.onopen = function(message) {
                // 콘솔 텍스트에 메시지를 출력한다.
                messageTextArea.value += "Server connect...\n";
            };
            // WebSocket 서버와 접속이 끊기면 호출되는 함수
            webSocket.onclose = function(message) {
                // 콘솔 텍스트에 메시지를 출력한다.
                messageTextArea.value += "Server Disconnect...\n";
            };
            // WebSocket 서버로 부터 메시지가 오면 호출되는 함수
            webSocket.onmessage = function(message) {
                // 콘솔 텍스트에 메시지를 출력한다.
                messageTextArea.value += "Recieve From Server => "+message.data+"\n";
            };
            // Send 버튼을 누르면 호출되는 함수
            function sendMessage() {
                webSocket.send(output.value);
            }
            // Disconnect 버튼을 누르면 호출되는 함수
            function disconnect() {
                // WebSocket 접속 해제
                webSocket.close();
            }

            function openFile() {
                var input = document.createElement("input");
                var fileInfo = document.getElementById("fileInfo");

                input.type = "file";
                input.accept = "text/plain, image/jpeg, .pkg, .dmg, .mp4"; // 확장자가 xxx, yyy 일때, ".xxx, .yyy"

                output = { value: undefined };

                input.onchange = function (event) {
                    processFile(event.target.files[0]);
                    var fileSize = Math.round(event.target.files[0].size / (1024*1024) * 10) / 10;
                    fileName = event.target.files[0].name;
                    fileInfo.value = fileName + " - " + fileSize+"Mb";
                };

                input.click();
            }

            function processFile(file) {
                var reader = new FileReader();

                reader.onload = function() {
                    output.value = reader.result;
                };
                reader.readAsArrayBuffer(file);
            }
        </script>
    </body>
</html>
