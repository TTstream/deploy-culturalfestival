const API_KEY='bsz1Z2%2FEJ2Aixom%2BFqbT%2B3Un7a56GuhvDoUcngvXatWX1e7XhdI4BKB0nYAT2FmiaUgpFUFOajgbm6Vw0CErnA%3D%3D';

var url=`http://api.data.go.kr/openapi/tn_pubr_public_cltur_fstvl_api`;
var queryParams = '?' + encodeURIComponent('serviceKey') + '='+API_KEY; /*Service Key*/
queryParams += '&' + encodeURIComponent('type') + '=' + encodeURIComponent('json'); /**/
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('200'); /**/
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('0'); /**/

fetch(url+queryParams)
    .then(response => response.json())
    .then(data => {
        console.log(data);
        console.log(data.response.body.items[0]);
        console.log(data.response.body.totalCount);
        const a=document.querySelector("#params");
        a.innerText=data.response.body.items[0].lnmadr //ex) 공공데이터의 위치 값 출력
        
});