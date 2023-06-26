<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <section class="join-form">

        <form action="/user/addUser.do" target="_self" accept-charset="utf-8">
            <div class="int-area">
                <input type="text" name="userid" id="id" autocomplete="off" required>
                <label for="id">ID</label>
            </div>
            <div class="int-area">
                <input type="password" name="userpw" id="pw" autocomplete="off" required>
                <label for="pw">PASSWORD</label>
            </div>
            <div class="int-area">
                <input type="text" name="nickname" id="pn" autocomplete="off" required>
                <label for="pn">NICKNAME</label>
            </div>
            <div class="int-area">
                <input type="EMAIL" name="email" id="em" autocomplete="off" required>
                <label for="em">EMAIL</label>
            </div>
            <div class="btn-area inAuth">
                <button class="inAuth" type="submit">회원가입</button>
            </div>
        </form>

    </section>
