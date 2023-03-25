/** 카카오 맵 실행하는 코드 */
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    center: new kakao.maps.LatLng(37.566535, 126.9779692), // 지도의 중심좌표 
    level: 11 // 지도의 확대 레벨 
});


var markers = [];
for (var i = 0; i < collect.data.length; i++) {
    markers.push({
        position: new kakao.maps.LatLng(collect.data[i].latitude, collect.data[i].longitude),
        content: `<div class ="label"><span class="center">${i+1}</span></div>`
    });
}

for (var i = 0; i < markers.length; i++) {
    // // 마커를 생성합니다
    // var marker = new kakao.maps.Marker({
    //     map:map,
    //     position: markers[i].position
    // });

    // 커스텀 오버레이를 생성합니다
    var customOverlay = new kakao.maps.CustomOverlay({
        position: markers[i].position,
        content: markers[i].content
    });

    // 커스텀 오버레이를 지도에 표시합니다
    customOverlay.setMap(map);
}

/**리스트 아이템 클릭시 주소 가져오기 */
document.querySelectorAll('#li_id').forEach(li => {
    li.addEventListener('click', event => {
        const address = event.currentTarget.querySelector('div:nth-child(3)').textContent;
        var addressIndex = address.indexOf('주소:');
        var addressText = address.slice(addressIndex + 3).trim();
        console.log(addressText);

        // Kakao Maps API에서 제공하는 지오코딩 서비스를 이용하여 주소를 좌표로 변환합니다.
        var geocoder = new kakao.maps.services.Geocoder();
        geocoder.addressSearch(addressText, function(result, status) {
            // 변환된 좌표가 없으면 오류 메시지를 출력합니다.
            if (status !== kakao.maps.services.Status.OK) {
                alert('해당 주소의 좌표를 찾을 수 없습니다.');
                const encodedAddress = encodeURIComponent(addressText);
                const url = `https://map.naver.com/v5/search/${encodedAddress}`;
                const win = window.open(url, '_blank');
                win.focus();
                return;
            }

            // 변환된 좌표로 지도의 중심 위치를 설정합니다.
            const center = new kakao.maps.LatLng(result[0].y, result[0].x);

            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(center);

             // Kakao Maps API에서 제공하는 마커 객체를 생성하여 변환된 좌표에 해당하는 위치에 마커를 표시합니다.
            const marker = new kakao.maps.Marker({
                position: center,
                map: map
            });


        });


    });
});