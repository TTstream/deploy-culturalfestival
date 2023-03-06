/* 주석 단축키 */
// /*  */ => alt+shift+a

const API_KEY='bsz1Z2%2FEJ2Aixom%2BFqbT%2B3Un7a56GuhvDoUcngvXatWX1e7XhdI4BKB0nYAT2FmiaUgpFUFOajgbm6Vw0CErnA%3D%3D';

var url=`http://api.data.go.kr/openapi/tn_pubr_public_cltur_fstvl_api`;

/* 한 페이지에 numOfRows개의 데이터를 받아오기 */
var queryParams = '?' + encodeURIComponent('serviceKey') + '='+API_KEY; /* Service Key */
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /* 페이지 번호 */
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('100'); /* 한 페이지 최대 결과 수 */
queryParams += '&' + encodeURIComponent('type') + '=' + encodeURIComponent('json'); /* XML/JSON 여부 */

fetch(url+queryParams)
    .then(response => response.json())
    .then(data => {
        const info=document.querySelector("#info"); /* table의 tbody id */
        festival_data=data.response.body.items;
        
        /* 화면에 공공 데이터 출력 */
        for(var num in festival_data){
            var output=``;
            /* fstvlNm = 축제명 */
            /* fstvlStartDate = 축제시작일자 */
            /* fstvlEndDate = 축제종료일자 */
            output=`<tr>
                         <th scope="row">${Number(num)+1}</th>
                         <td>${festival_data[num].fstvlNm}</td>
                         <td>${festival_data[num].fstvlStartDate}</td>
                         <td>${festival_data[num].fstvlEndDate}</td>
                    </tr>`;
            info.innerHTML+=output;
        }
});




