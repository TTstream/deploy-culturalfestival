function changeSelect(){

    // 드롭다운에서 선택한 값 가져오기
    var selectValue = $("#selectbox option:selected").text();

    if (selectValue==="전체"){
        // 전체면 2021~2024년도 값 가져오기
        selectValue=0
    }else{
        // 아니면 년을 기준으로 숫자값(2021,2022,2023,2024)만 가져오기
        selectValue=selectValue.split('년',1).toString() //객체를 문자열로 변환
    }

    // Ajax생성해서 Controller로 값 전달
    $.ajax({
        url : "/yearSelect",
        type : 'GET',
        data : {"selectValue":selectValue},
        success : function(data) {
            alert(data);
         },
        error : function() {
            alert("error");
        }
    });

}