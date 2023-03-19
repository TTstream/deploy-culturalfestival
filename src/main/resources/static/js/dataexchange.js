function changeSelect() {

    // 드롭다운에서 선택한 값 가져오기
    var selectValue = $("#selectbox option:selected").text();

    if (selectValue === "전체") {
        // 전체면 2021~2024년도 값 가져오기
        selectValue = 0
    } else {
        // 아니면 년을 기준으로 숫자값(2021,2022,2023,2024)만 가져오기
        selectValue = selectValue.split('년', 1).toString() //객체를 문자열로 변환
    }

    // Ajax생성해서 Controller로 값 전달
    $.ajax({
        url: "/yearSelect",
        type: 'GET',
        data: { "selectValue": selectValue },
        success: function (data) { // Controller에게 받아온 값
            var totalfestivalsapn = document.querySelector("#totalfestival span"); //총건수 표시해주기위해 
            totalfestivalsapn.textContent = `${data.length}`; //총건수표시

            const parent = document.getElementById('info'); //tbody 값
            var html=""; //controller에서 받은 data를 가공해서 화면에 표시
            data.forEach((apiDataDto, index) => {
              html += `<tr>
                          <th scope="row">${index+1}</th>
                          <td>${apiDataDto.fstvlNm}</td>
                       </tr>`;
            });
            parent.innerHTML = html;

        },
        error: function () {
            alert("error");
        }
    });

}