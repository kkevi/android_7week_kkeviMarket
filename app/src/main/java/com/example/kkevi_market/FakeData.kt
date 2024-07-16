package com.example.kkevi_market

class FakeData(){
    companion object {
        val data = mutableListOf<MainListViewItemData>()
    }

    private val data1: MainListViewItemData = MainListViewItemData(1, User(1, "대현동", "서울 서대문구 창천동"), R.drawable.sample1, "산 지 한달된 선풍기 팝니다", "이사 가서 필요가 없어졌어요. 급하게 내놓습니다.", 1000, 13, 25)
    private val data2: MainListViewItemData = MainListViewItemData(2, User(1, "안마담", "인천 계양구 귤현동"), R.drawable.sample2, "김치 냉장고", "이사로 인해 내놔요.", 1000, 8, 28)
    private val data3: MainListViewItemData = MainListViewItemData(3, User(1, "코코유", "수성구 범어동"), R.drawable.sample3, "샤넬 카드지갑", "고퀄 지갑이구요.\\n사용감이 있어서 싸게 내어둡니다.", 1000, 23, 5)
    private val data4: MainListViewItemData = MainListViewItemData(4, User(1, "Nicole", "해운대구 우제2동"), R.drawable.sample4, "금고", "금고\\n떼서 가져 가야 함\\n대우 월드 마크 센텀\\n미국 이주 관계로 싸게 팝니다.", 1000, 14, 17)
    private val data5: MainListViewItemData = MainListViewItemData(5, User(1, "절명", "연제구 연산제8동"), R.drawable.sample5, "갤럭시Z 플립3 팝니다.", "갤럭시 Z플립3 그린 팝니다.\\n항시 케이스 씌워서 썻고 필름 한 장 챙겨 드립니다.\\n화면에 살짝 스크래치 난 거 말고 크게 이상은 없습니다!", 1000, 22, 9)
    private val data6: MainListViewItemData = MainListViewItemData(6, User(1, "미니멀하게", "수원시 영통구 원천동"), R.drawable.sample6, "프라다 복조리 백", "까임 오염 없고 상태 깨끗합니다\\n정품여부모름", 1000, 25, 16)
    private val data7: MainListViewItemData = MainListViewItemData(7, User(1, "굿리치", "남구 옥동"), R.drawable.sample7, "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장", "울산 동해바다뷰 60평 복층 펜트하우스 1일 숙박권\\n(에어컨이 없기에 낮은 가격으로 변경했으며 8월 초 가장 더운날 다녀가신 분 경우 시원했다고 잘 지내다 가셨습니다)\\n1. 인원: 6명 기준입니다. 1인 10,000원 추가요금\\n2. 장소: 북구 블루마시티, 32-33층\\n3. 취사도구, 침구류, 세면도구, 드라이기 2개, 선풍기 4대 구비\\n4. 예약방법: 예약금 50,000원 하시면 저희는 명함을 드리며 입실 오전 잔금 입금하시면 저희는 동.호수를 알려드리며 고객님은 예약자분 신분증 앞면 주민번호 뒷자리 가리시거나 지우시고 문자로 보내주시면 저희는 카드키를 우편함에 놓아 둡니다.\\n5. 33층 옥상 야외 테라스 있음, 가스버너 있음\\n6. 고기 굽기 가능\\n7. 입실 오후 3시, 오전 11시 퇴실, 정리, 정돈 , 밸브 잠금 부탁드립니다.\\n8. 층간소음 주의 부탁드립니다.\\n9. 방3개, 화장실3개, 비데 3개\\n10. 저희 집안이 쓰는 별장입니다.", 1000, 142, 54)
    private val data8: MainListViewItemData = MainListViewItemData(8, User(1, "난쉽", "동래구 온천제2동"), R.drawable.sample8, "샤넬 탑핸들 가방", "울산 동해바다뷰 60평 복층 펜트하우스 1일 숙박권\\n(에어컨이 없기에 낮은 가격으로 변경했으며 8월 초 가장 더운날 다녀가신 분 경우 시원했다고 잘 지내다 가셨습니다)\\n1. 인원: 6명 기준입니다. 1인 10,000원 추가요금\\n2. 장소: 북구 블루마시티, 32-33층\\n3. 취사도구, 침구류, 세면도구, 드라이기 2개, 선풍기 4대 구비\\n4. 예약방법: 예약금 50,000원 하시면 저희는 명함을 드리며 입실 오전 잔금 입금하시면 저희는 동.호수를 알려드리며 고객님은 예약자분 신분증 앞면 주민번호 뒷자리 가리시거나 지우시고 문자로 보내주시면 저희는 카드키를 우편함에 놓아 둡니다.\\n5. 33층 옥상 야외 테라스 있음, 가스버너 있음\\n6. 고기 굽기 가능\\n7. 입실 오후 3시, 오전 11시 퇴실, 정리, 정돈 , 밸브 잠금 부탁드립니다.\\n8. 층간소음 주의 부탁드립니다.\\n9. 방3개, 화장실3개, 비데 3개\\n10. 저희 집안이 쓰는 별장입니다.", 1000, 31, 7)
    private val data9: MainListViewItemData = MainListViewItemData(9, User(1, "알뜰한", "원주시 명륜2동"), R.drawable.sample9, "4행정 엔진 분무기 판매 합니다..", "3년전에 사서 한번 사용 하고 그대로 둔 상태입니다. 요즘 사용은 안 해봤습니다. 그래서 저렴하게 내놓습니다. 중고라 반품은 어렵습니다.\\n", 1000, 7, 28)
    private val data10: MainListViewItemData = MainListViewItemData(10, User(1, "똑태현", "중구 동화동"), R.drawable.sample10, "셀린느 버킷 가방", "22년 신세계 대전 구매 입니당\\n + \"셀린느 버킷백\\n\" + \"구매해서 몇 번 사용 했어요\\n\" + \"까짐 스크래치 없습니다.\\n\" + \"타지역에서 보내는거라 택배로 진행합니당!\"", 1000, 40, 6)

    init{
        data.add(data1)
        data.add(data2)
        data.add(data3)
        data.add(data4)
        data.add(data5)
        data.add(data6)
        data.add(data7)
        data.add(data8)
        data.add(data9)
        data.add(data10)
    }
}