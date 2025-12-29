<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>뉴아즈 네일샵</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/reservation_dashboard.css">
    </head>

    <body>
        <jsp:include page="include/navbar.jsp" />

        <main>
            <div class="dashboard-container">
                <div class="dashboard-header">
                    <h1 class="dashboard-title">📅 조성은 원장 & 유재인 실장 스케줄</h1>
                    <div class="header-btns">
                        <button class="btn-primary" onclick="alert('예약 등록창 오픈')">+ 예약등록</button>
                    </div>
                </div>

                <!-- 직원 2인 공유 대시보드 -->
                <div class="staff-view-container">
                    <!-- 원장 스케줄 -->
                    <div class="staff-column">
                        <div class="staff-header">
                            <div class="staff-name">조성은 원장님 👑</div>
                            <div class="staff-role">Master Designer</div>
                        </div>
                        <div class="reservation-list">
                            <!-- 예시 예약 블록 -->
                            <div class="res-block">
                                <input type="checkbox" class="complete-check"
                                    onclick="$(this).parent().toggleClass('completed')">
                                <div class="res-time">10:00 - 11:30</div>
                                <div class="res-service">💅 젤 네일 (아트추가)</div>
                                <div class="res-customer">이민지 고객님</div>
                            </div>
                            <div class="res-block">
                                <input type="checkbox" class="complete-check"
                                    onclick="$(this).parent().toggleClass('completed')">
                                <div class="res-time">13:00 - 14:00</div>
                                <div class="res-service">✨ 파츠 무제한</div>
                                <div class="res-customer">박수아 고객님</div>
                            </div>
                        </div>
                    </div>

                    <!-- 매니저 스케줄 -->
                    <div class="staff-column">
                        <div class="staff-header">
                            <div class="staff-name">유재인 실장님🌸</div>
                            <div class="staff-role">Senior Designer</div>
                        </div>
                        <div class="reservation-list">
                            <div class="res-block">
                                <input type="checkbox" class="complete-check"
                                    onclick="$(this).parent().toggleClass('completed')">
                                <div class="res-time">11:00 - 12:00</div>
                                <div class="res-service">🎨 원컬러 젤</div>
                                <div class="res-customer">최유진 고객님</div>
                            </div>
                            <!-- 빈 공간 예시 -->
                            <div class="timeline-placeholder">
                                현재 예약이 없습니다.
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!-- 푸터 제거됨 -->

        <style>
            /* 기존 스타일 유지하면서 navbar 대응 */
            .btn-primary {
                padding: 10px 20px;
                background-color: var(--dusty-rose);
                color: #fff;
                border: none;
                border-radius: var(--radius-md);
                font-weight: 700;
                cursor: pointer;
                transition: all 0.3s;
            }

            .btn-primary:hover {
                background-color: var(--main-pink);
                transform: translateY(-2px);
            }

            .res-time {
                font-size: 13px;
                opacity: 0.9;
            }

            .res-service {
                font-size: 18px;
                font-weight: 700;
                margin: 5px 0;
            }

            .res-customer {
                font-size: 14px;
                opacity: 0.8;
            }
        </style>
    </body>

    </html>