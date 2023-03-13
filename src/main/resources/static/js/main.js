/* 주석 단축키 */
// /*  */ => alt+shift+a

/*  
1. API 요청

2. 응답받은 JSON 혹은 XML을 DB 형태(컬럼)에 맞게 파싱

3. 파싱한 데이터를 DB에 삽입

4. 데이터가 정상삽입 되는게 확인됬다면 1 ~ 3까지의 동작을 스케쥴러 혹은 배치를 이용하여 주기적으로 실행
*/

const API_KEY='bsz1Z2%2FEJ2Aixom%2BFqbT%2B3Un7a56GuhvDoUcngvXatWX1e7XhdI4BKB0nYAT2FmiaUgpFUFOajgbm6Vw0CErnA%3D%3D';

var url=`http://api.data.go.kr/openapi/tn_pubr_public_cltur_fstvl_api`;

/* 한 페이지에 numOfRows개의 데이터를 받아오기 */
var queryParams = '?' + encodeURIComponent('serviceKey') + '='+API_KEY; /* Service Key */
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /* 페이지 번호 */
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('500'); /* 한 페이지 최대 결과 수 */
queryParams += '&' + encodeURIComponent('type') + '=' + encodeURIComponent('json'); /* XML/JSON 여부 */

fetch(url+queryParams)
    .then(response => response.json())
    .then(data => {

        publicdataShow(data)
        console.log(data)
        
});

/**
 * @param data 공공데이터
 */
function publicdataShow(data){

    const info=document.querySelector("#info"); /* table의 tbody id */
    festival_data=data.response.body.items;
    const date=new Date()

    /* 화면에 공공 데이터 출력 */
    for(var num in festival_data){
        startYear=festival_data[num].fstvlStartDate.split('-',1)

        /* 축제 시작일(fstvlStartDate)이 현재 년도와 같을 때 출력 */
        if (parseInt(startYear)===date.getFullYear()){
            var output=``;
            /* fstvlNm = 축제명 */
            /* fstvlStartDate = 축제시작일자 */
            /* fstvlEndDate = 축제종료일자 */
            output=`<tr>
                        <th scope="row">${Number(num)+1}</th>
                        <td>${festival_data[num].fstvlNm}</td>
                    </tr>`;
            info.innerHTML+=output;
        }
    }

}




