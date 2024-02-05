const deleteButton = document.getElementById('delete-btn');

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document. getElementById('article-id'). value;
        fetch(`/api/articles/${id}`,{
        method: 'DELETE'
    })
        .then (() => {
            alert('삭제가 완료되었습니다. ');
            location.replace ('/articles');
        });
    });
}

const modifyButton = document.getElementById('modify-btn');
if (modifyButton) {
    // 클릭 이벤트가 감지되면 수정 API 요청
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');
        fetch(`/api/articles/${id}`, { // 문자열 시작을 백틱(`)으로 수정
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            .then(response => { // .then 구문 수정 및 response 매개변수 추가
                if (response.ok) { // 응답 상태 확인
                    alert('수정이 완료되었습니다.');
                    location.replace(`/articles/${id}`); // 문자열 시작을 백틱(`)으로 수정
                } else {
                    alert('수정에 실패했습니다.');
                }
            });
    });
}
