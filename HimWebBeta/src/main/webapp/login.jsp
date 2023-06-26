<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



    <section class="login-form">
        <div> <!--   action="/user/checkUserLogin.do" target="_self" accept-charset="utf-8" -->
            <div class="int-area">
                <input type="text" name="userid" id="id" class="loginUserID" autocomplete="off" required>
                <label for="id">ID</label>
            </div>
            <div class="int-area">
                <input type="password" name="userpw" id="pw" class="loginUserPW" autocomplete="off" required>
                <label for="pw">PASSWORD</label>
            </div>
            <p id="joinText" onClick="showModal('join')">회원가입</p>
            <div class="btn-area inAuth">
                <button class="inAuth"onClick="ActionLogin()">LOGIN</button> <!--  type="submit"  -->
            </div>
        </div>
    </section>
