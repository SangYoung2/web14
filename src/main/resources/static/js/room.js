const RoomContainer = document.getElementById('room_container');
const addRoom = document.forms.namedItem('add_room');

window.onload = () => {
    get_all_rooms();
}

function add_room_info(){
    const roomInputs = [...document.getElementById('new_room_info').getElementsByTagName('input')];
    const roomInfo = {
        roomNo: roomInputs[0].value,
        roomPrice: roomInputs[1].value,
        roomSize: roomInputs[2].value,
        roomImg: roomInputs[3].value
    }
    return roomInfo;
}

// 방 정보를 POST하는 함수 (새 방을 생성)
function post_room(){
    const roomInfo = add_room_info();
    console.log(roomInfo)
    const request = new XMLHttpRequest();
    request.open('POST', '/room');
    request.setRequestHeader('content-type','application/json')
    request.send(JSON.stringify(roomInfo));
    //POST 요청이 정상적으로 완료되었을 경우, 모든 방 정보를 재 로드한다.
    request.onload = () => {
        get_all_rooms();
    }
}

function del_room(){
    const request = new XMLHttpRequest();
    console.log(this);
    console.log(JSON.parse(request.response));
    // request.open('DEL', '/room');
    // request.setRequestHeader('content-type','application/json')
    // request.send();
}

// 모든 방 정보를 GET으로 가져오는 함수
function get_all_rooms(){
    const request = new XMLHttpRequest();
    request.open('GET', '/room');
    request.send();
    request.onload = () => {
        if(request.status == 200){
            make_room_info(JSON.parse(request.response));
        }
    }
}

// 모든 방의 정보를 생성하는 함수
function make_room_info(roomObs){
    for(room of roomObs){
        let isEmptyText = room.reserveVO === null ? '비었음' : '예약중';
        const roomNo = room.roomVO.roomNo;
        const roomPrice = room.roomVO.roomPrice;
        const roomSize = room.roomVO.roomSize;

        const roomInfoHTML = '<div class="room_box">\n' +
            '            <form id="room_info">\n' +
            '                <div>\n' +
            '                    <span style="background-color: indianred">' + isEmptyText + '</span>\n' +
            '                    <button>숨기기</button>\n' +
            '                    <button onclick="del_room(this)">X</button>\n' +
            '                </div>\n' +
            '                <span>방번호: '+ roomNo +'</span>\n' +
            '                <img width="200px" src="/image/' + roomNo + '.png">\n' +
            '                <span>인원수(최대):' + roomSize + '</span>\n' +
            '                <span>가격: '+ roomPrice +'</span>\n' +
            '            </form>\n' +
            '        </div>';

        RoomContainer.insertAdjacentHTML('beforeend',roomInfoHTML)
    }


}