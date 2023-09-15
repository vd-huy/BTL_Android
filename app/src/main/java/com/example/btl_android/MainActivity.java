package com.example.btl_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    Button btnHN, btnNB,btnDN;
    SQLite sqlDiaDiem;
    Integer i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHN = (Button) findViewById(R.id.HaNoi);
        btnDN = (Button) findViewById(R.id.DaNang);
        btnNB = (Button) findViewById(R.id.NinhBinh);

        sqlDiaDiem = new SQLite(MainActivity.this, "dulich.sqlite", null, 1);

        sqlDulich();

        btnHN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                sqlDiaDiem = new SQLite(MainActivity.this, "dulich.sqlite", null, 1);

                Intent intent = new Intent(MainActivity.this, InforLocation.class);
                intent.putExtra("Tinh", "Hà Nội");
                startActivity(intent);
            }
        });

        btnNB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                sqlDiaDiem = new SQLite(MainActivity.this, "dulich.sqlite", null, 1);

                Intent intent = new Intent(MainActivity.this, InforLocation.class);
                intent.putExtra("Tinh", "Ninh Bình");
                startActivity(intent);
            }
        });


        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                sqlDiaDiem = new SQLite(MainActivity.this, "dulich.sqlite", null, 1);

                Intent intent = new Intent(MainActivity.this, InforLocation.class);
                intent.putExtra("Tinh", "Đà Nẵng");
                startActivity(intent);
            }
        });


    }

    public void sqlDulich() {
        sqlDiaDiem.QueryData
                //khoi tao cac bang
                        ("CREATE TABLE IF NOT EXISTS Tinh (\n" +
                                "    IdTinh INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                                "    tenTinh NVARCHAR(50) UNIQUE NOT NULL\n" +
                                ")");

        sqlDiaDiem.QueryData("CREATE TABLE IF NOT EXISTS DiaDiem(\n" +
                "\tId INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT ,\n" +
                "\ttenDiaDiem NVARCHAR(50),\n" +
                "\tthongTin TEXT,\n" +
                "\ttenTinh NVARCHAR(50), \n" +
                "\tdiaChi NVARCHAR(500),\n" +
                "\trate FLOAT,\n" +
                "\thinhAnh BLOG, \n"+
                "\tFOREIGN KEY (tenTinh) REFERENCES Tinh(TenTinh)\n"+
                ")\n");

        // insert du lieu tinh
//        sqlDiaDiem.INSERT_Tinh("Hà Nội");
//        sqlDiaDiem.INSERT_Tinh("Ninh Bình");
//        sqlDiaDiem.INSERT_Tinh("Đà Nẵng");
//
//        //insert du lieu dia diem
//        sqlDiaDiem.INSERT_DiaDiem("Tràng An", "Quần thể Tràng An ở Ninh Bình không chỉ là danh thắng quan trọng và nổi bật bậc nhất phía bắc Việt Nam, mà còn được UNESCO công nhận là di sản thế giới. Hằng năm nơi đây thu hút hàng triệu lượt khách đến tham quan thưởng ngoạn, điều đáng nói là trong đó lượng khách du lịch nước ngoài rất đông. Có thể thấy Tràng An là viên ngọc sáng nhất trong hàng loạt các thắng cảnh của Ninh Bình.\n" +
//                "\n" +
//                "Nơi đây có dãy núi đá vôi với 250 triệu năm tuổi, và trải qua thời gian biến đổi, phong hóa, Tràng An mang một vẻ đẹp rất thơ và đầy quyến rũ với hàng loạt những thung lũng, hồ đầm, hang động, với những cánh rừng ngập nước hay rừng trên núi đá vôi tuyệt đẹp. Đến với Ninh Bình, du khách có thể tham quan cả quần thể danh thắng Tràng An đó là Tràng An - Tam Cốc – Bích Động – Cố đô Hoa Lư – rừng đặc dụng Hoa Lư.\n"+
//                "\n" +
//                "Thời điểm thích hợp nhất để du lịch Tràng An là tháng 1 đến tháng 3 âm lịch. Thời tiết lúc này không quá lạnh, trời trong xanh và mát, không có mưa nên rất thích hợp với du lịch ngắm cảnh ngoài trời khi đến Tràng An \n" +
//                "\n"+
//                "Với những ai thích ngắm cánh đồng lúa chín vàng trên thuyền thì thời điểm tháng 7 đến tháng 9 là thích hợp. Tháng 6, thời tiết tuy có oi bức nhưng trời lạnh và ít mưa cũng rất thích hợp. Tháng 11 và tháng 12 thời tiết xấu, mưa nhiều vì thế bạn nên tránh du lịch Tràng An vào thời gian này.", "Ninh Bình" , "Núi Kỳ Lân, Phường Tân Thành, Thành phố Ninh Bình, Tỉnh Ninh Bình", 4.5, anh(R.drawable.anhtrangan)
//        );
//
//        sqlDiaDiem.INSERT_DiaDiem("Chùa Bái Đính", "Chùa Bái Đính là một điểm du lịch tâm linh nổi tiếng nằm trong khu du lịch sinh thái Bái Đính – Tràng An, với tuổi đời hơn 1000 năm tuổi và gắn liền với vùng đất của nhiều triều đại phong kiến từ nhà Đinh, nhà Tiền Lê đến nhà Lý.\n" +
//                "\n" +
//                "Du khách khi đặt chân đến đây sẽ bị thu hút bởi kiến trúc hoành tráng, những bảo tháp nguy nga và khung cảnh làm say đắm lòng người. Hằng năm, địa điểm này thu hút một lượng du khách đến tham quan và vãn cảnh chùa. Không gây ấn tượng với du khách bởi kiến trúc độc đáo mà còn sở hữu nhiều cái nhất ở Việt Nam và trên thế giới.\n"+
//                "\n" +
//                "Chùa Bái Đính thuộc phía Bắc của quần thể du lịch sinh thái Bái Đính - Tràng An. Là một trong những địa danh nổi tiếng tại Ninh Bình, cùng với bề dày lịch sử và sự phát triển. Chùa Bái Đính nằm trên núi Bái Đính ở xã Gia Sinh, huyện Gia Viên, cách cố đô Hoa Lư 5km về phía Tây Bắc, cách thành phố Ninh Bình 12km. Khuôn viên chùa Bái Đính có diện tích rộng 539 ha bao gồm 27 ha khu chùa Bái Đính cổ, 80ha khu chùa Bái Đính mới. \n" +
//                "\n"+
//                "Mỗi mùa, quần thể du lịch Tràng An khoác lên mình một nét đẹp riêng làm say đắm bao lữ khách. Vậy nên, du khách có thể đến tham quan chùa Bái Đinh bất kể mùa nào trong năm. Tuy nhiên, theo kinh nghiệm du lich chùa Bái Đính - Tràng An, thời gian thích hợp nhất là từ tháng 1 đến tháng 3 âm lịch, lúc này thời tiết vô cùng mát mẻ và trong lành, rất nhiều lễ hội được tổ chức trong thời điểm này. Vì thế, du khách có thể đi lễ chùa Bái Đính để thưởng ngoạn không khí Tết.", "Ninh Bình" , "Chùa Bái Đính, Gia Sinh, Gia Viễn, Ninh Bình", 4.5, anh(R.drawable.anhchuabaidinh)
//        );
//
//        sqlDiaDiem.INSERT_DiaDiem("Tam Cốc - Bích Động", "Tam Cốc Bích Động - Ninh Bình là một phần trong quần thể danh thắng Tràng An - Di sản thế giới được UNESCO công nhận về các giá trị văn hóa và tự nhiên vào năm 2014. Tam Cốc Bích Động là một khu vực rộng lớn, nổi bật nhất là những hang động đá vôi, khung cảnh làng quê hòa mình vào thiên nhiên tuyệt đẹp.\n" +
//                "\n" +
//                "Khu du lịch Tam Cốc - Bích Động với diện tích tự nhiên là 350,3 ha, nằm cách quốc lộ 1A 2km, cách thành phố Ninh Bình 7 km, chủ yếu khu vực nằm trên xã Ninh Hải (Hoa Lư). Cũng giống như Tràng An, để đi tham quan Tam Cốc, du khách phải đi bằng thuyền, xuôi theo dòng sông Ngô Đồng thơ mộng, nước trong xanh một màu có thể nhìn thấy đấy để chiêm ngưỡng động. Khung cảnh Tam Cốc nổi bật bởi sự kết hợp hài hòa của đá và nước. Các ngọn núi với ở đây mang những hình thù đa dạng, nối tiếp nhau, ngọn này đến ngọn khác.\n"+
//                "\n" +
//                "Du khách có thể đi Tam Cốc Bích Động vào khoảng tháng 4, lúc này tiết trời hanh khô, không có nóng ẩm khó chịu đầu năm ở miền Bắc nhưng cũng chưa quá nắng, thời tiết ít mưa nên 2 tiếng ngồi thuyền cũng là vấn đề bạn cần chú ý.\n" +
//                "\n"+
//                "Khoảng từ tháng 1 đến tháng 3 âm lịch hàng năm là mùa lễ hội chùa Bái Đính, du khách có thể kết hợp đi lễ và khám phá Tam Cốc Bích Động vào dịp này.", "Ninh Bình","Núi Kỳ Lân, Phường Tân Thành, Thành phố Ninh Bình, Tỉnh Ninh Bình", 4.5, anh(R.drawable.anhtamcoc)
//        );
//
//        sqlDiaDiem.INSERT_DiaDiem("Cố Đô Hoa Lư", "Thành phố Ninh Bình cách thủ đô Hà Nội 93km về phía Nam, tại đầu mối giao thông của 3 tuyến đường cao tốc Cầu Giẽ - Ninh Bình, Ninh Bình - Thanh Hóa - Vinh và Ninh Bình - Hải Phòng - Hạ Long. Ninh Bình nổi tiếng với các điểm du lịch như: Chùa Bái Đính, khu du lịch sinh thái Vườn Chim Thung Nham, rừng Cúc Phương, Tràng An, Tam Cốc Bích Động... và không thể thiếu Cố Đô Hoa Lư.\n" +
//                "\n" +
//                "Nằm giáp ranh giữa 2 huyện Hoa Lư và Gia Viễn thành phố Ninh Bình của tỉnh Ninh Bình, kinh đô Hoa Lư xưa. Cố đô được biết đến với nhiều di tích lịch sử có giá trị và điểm đến với nhiều thắng cảnh đẹp, thiên nhiên tươi mát hấp dẫn du khách. Cố Đô Hoa Lư được UNESCO công nhận là một trong 4 vùng lõi thuộc quần thể di sản thế gới Tràng An.\n"+
//                "\n" +
//                "Ninh Bình nổi tiếng là vùng đất của cố đô, nơi đây có kinh đô Hoa Lư hằng năm vẫn diễn ra hàng loạt các lễ hôi đặc sắc để tưởng niệm các vị vua đá có công xây dựng đất nước.\n" +
//                "\n"+
//                "Du khách nên du lịch đến Ninh Bình vào mùa khô, bắt đầu từ tháng 11 đến tháng 3 năm sau. Hạn chế đi vào mùa nước lớn vì có thể du khách sẽ không đi được thuyền vào các hang động. Vào mùa hè thì thời tiết sẽ có nắng đẹp, mát mẻ hơn so với mùa đông.", "Ninh Bình" , "Trường Yên, Hoa Lư, Ninh Bình, Việt Nam", 4.5, anh(R.drawable.anhcodohoalu)
//        );
//
//        sqlDiaDiem.INSERT_DiaDiem("Hồ Hoàn Kiếm", "Hồ nước ngọt này nằm ngay trung tâm Thủ Đô Hà Nội, có diện tích khoảng 12 hecta. Bao quanh hồ là các phố Lê Thái Tổ ở phía Tây, phố Đinh Tiên Hoàng ở phía Đông, phố Hàng Khay phía nam, tượng vua Lê Thái Tổ, cầu Thê Húc, tháp Bút, đền Bà Kiệu,...Hồ Hoàn Kiếm là di sản vô giá gắn với những truyền thuyết lịch sử và văn hóa linh thiêng từ lâu đời.\n" +
//                "\n" +
//                "Cách đây khoảng 6 thế kỷ, hồ Gươm có tên là hồ Lục Thủy. Nhưng đến thế kỷ XV, hồ được đổi tên thành hồ Hoàn Kiếm, gắn liền với truyền thuyết vua Lê Lợi trả gươm thần. Chuyện kể về thời giặc Minh hoành hành ở nước ta, vua Lê Lợi cầm quân đánh giặc, khi đó được rùa thần Kim Quy tặng cho thanh gươm thần. Đánh tan giặc, ông lên ngôi lấy hiệu là Lê Thái Tổ, dời đô về Thăng Long. Trong một lần vua dạo chơi trên hồ Lục Thủy, rùa thần nổi lên xin vua trả lại thanh gươm báu. Từ đó, hồ này đổi tên thành hồ Hoàn Kiếm.\n"+
//                "\n" +
//                "Quanh hồ có trồng nhiều hoa và cây cảnh mang lại cảm giác thoáng mát gần gũi với thiên nhiên. Hồ Hoàn Kiếm không chỉ là điểm nghỉ chân sau những chặng đường dài lang thang du hí, du khách đến đây còn được cảm nhận đời sống của người dân thủ đô hàng ngày.\n" +
//                "\n"+
//                "Mỗi năm vào dịp tết Nguyên Đán, người người nô nức du xuân quanh hồ. Thời điểm này, hồ cũng là nơi gặp gỡ của nam nữ, chụp ảnh cưới của các đôi uyên ương, ảnh lưu niệm. Hè đến, nơi đây là điểm hóng mát lý tưởng dưới những tán cây rợp bóng. Du khách sẽ phải thảng thốt trước vẻ đẹp e lệ của những cây bằng lăng tím rạng rỡ, những cây phượng cháy đỏ.", "Hà Nội" , "Quận hoàn kiếm, Thành phố hà nội, Việt Nam", 4.5, anh(R.drawable.anhhohoankiem)
//        );
//
//        sqlDiaDiem.INSERT_DiaDiem("Lăng Chủ Tịch Hồ Chí Minh", "Nằm trong trung tâm thủ đô Hà Nội, Lăng Chủ Tịch là trái tim của Hà Nội. Nơi đây cất giữ di hài của vị cha già dân tộc đang yên giấc ngủ ngàn thu. Một nhà yêu nước lớn, một danh nhân văn hóa thế giới, một vị lãnh tụ của Việt Nam mà nhiều vị lãnh tụ khác phải kính trọng và nể phục.\n" +
//                "\n" +
//                "Được khởi công vào ngày 2 tháng 9 năm 1973, tại vị trí của lễ đài cũ giữa quảng trường Ba Đình - nơi người đã từng chủ trì cuộc mít tinh lớn. Lăng Chủ Tịch cao 21.6m, gồm 3 lớp.\n"+
//                "\n" +
//                "Với lớp trên là mái lăng hình tam cấp. Mặt chính lăng có hàng chữ Chủ Tịch Hồ Chí Minh bằng đá ngọc màu mận chín. Vật liệu xây lăng là đá huyền đen Vĩnh Linh, đá hoa gấm, đá mã não.\n" +
//                "\n"+
//                "Phía trước lăng là quảng trường Ba Đình rộng lớn, lá cờ đỏ sao vàng cao 29 m tung bay phất phới trong nắng sớm như hình ảnh Bác Hồ vẫy chào những đứa con của mình. Với thảm cỏ dài 38 hecta, chia thành 240 ô vuông cỏ xanh tươi suốt bốn mùa.", "Hà Nội" , "Số 1, Đường Hùng Vương, Điện Biên, Ba Đình, Tp. Hà Nội", 4.5, anh(R.drawable.anhlangbac)
//        );
//
//        sqlDiaDiem.INSERT_DiaDiem("Văn Miếu Quốc Tử Giám", "Văn Miếu - Quốc Tử Giám là quần thể di tích đa dạng và phong phú còn nguyên vẹn ở Hà Nội, nằm ở phía Nam kinh thành Thăng Long. Nếu có dịp đi du lịch Hà Nội, các bạn nên dành chút thời gian để tham quan Văn Miếu - Quốc Tử Giám, trường đại học đầu tiên của Việt Nam, nơi đây hứa hẹn nhiều thông tin thú vị cho các bạn tự khám phá.\n" +
//                "\n" +
//                "Được khởi lập vào cuối thế kỷ XI, Văn Miếu - Quốc Tử Giám là quần thể bao gồm Văn Miếu và Quốc Tử Giám. Quần thể di tích này nằm trên diện tích là 54.331m gồm hồ Minh Đường, vườn Giám và Nội Tự được bao bọc bởi những bức tường gạch vồ. Bốn mặt di tích đều là phố: phố Quốc Tử Giám (phía Nam), phố Nguyễn Thái Học (phía Bắc), phố Tôn Đức Thắng(phía Tây), phố Văn Miếu (phố Đông).\n"+
//                "\n" +
//                "Giữa những ồn ào và vội vã, Văn Miếu Quốc Tử Giám uy nghiêm, yên tĩnh nằm cách xa khỏi cuộc sống xô bồ và bận rộn. Tới đây du khách không khỏi bất ngờ bởi lối kiến trúc tinh tế sơn thủy hữu tình. Phía trước cổng lớn vào là tứ trụ (bốn cột lớn).\n" +
//                "\n"+
//                "Du khách sẽ được tham quan 5 khu vực trong Nội tự, mỗi khu được giới hạn bởi các tường gạch vồ và có các cửa thông nhau, một cửa chính giữa và 2 cửa phụ hai bên. Văn Miếu Môn - cổng dẫn vào khu thứ nhất. Gian giữa cổng treo một tấm biển nhỏ đề 3 chữ sơn then Đại Trung môn.", "Hà Nội" , "Quốc Tử Giám, Quận Đống Đa, Hà Nội", 4.5, anh(R.drawable.anhvanmieu)
//        );
//
//        sqlDiaDiem.INSERT_DiaDiem("Chùa Một Cột", "Chùa Một Cột hay Chùa Mật, còn có tên khác là Diên Hựu Tự, là một ngồi chùa nằm giữa lòng thủ đô Hà Nội với lối kiến trúc độc đáo có tòa sen ở giữa. Được xây dựng từ đời lý Thái Tông. Từ khi xây dựng cho đến nay, ngôi chùa đã được gìn giữ và trải qua nhiều đợt trùng tu lớn nhất là đợt trùng tu năm 1954 khi bị Pháp cho nổ.\n" +
//                "\n" +
//                "Đây là một công trình kiến trúc sáng tạo kết hợp không gian kiến trúc có nhịp điệu cao thấp, gồm các điêu khắc, hội họa, chạm vẽ hành lang, mặt nước là biểu tượng văn hóa, nghệ thuật cao, tính dân tộc đậm nét. Không những được đánh giá là ngôi chùa có kiến trúc nghệ thuật độc nhất ở Việt Nam, chùa Một Cột còn là một điểm đến tâm linh, biểu tượng văn hóa ngàn năm của thủ đô Hà Nội.Vào năm 2012, Chùa Một Cột được Tổ Chức Kỷ lục Châu Á xác lập kỷ lục là Ngôi chùa có kiến trúc độc đáo nhất.\n"+
//                "\n" +
//                "Chùa có hình vuông mỗi chiều 3m, mái cong dựng trên cột đá hình trụ cao 4m, có đường kính là 1,2m. Trụ đá gồm 2 khối, gắn rất khéo.\n" +
//                "\n"+
//                "Kết cấu nguyên bản của chùa Một Cột được đỡ bởi các dầm gỗ bám chắc cột đá. Cấu trúc của chùa Một Cột hiện nay gồm: Cột trụ, đài Liên hoa, mái chùa.", "Hà Nội" , "Phố chùa Một Cột, Quận Ba Đình, Tp. Hà Nội", 4.5, anh(R.drawable.anhchuamotcot)
//        );
//
//        sqlDiaDiem.INSERT_DiaDiem("Chùa Linh Ứng", "Nằm ở độ cao 693 mét so với mực nước biển, với diện tích 20 hecta, trên địa hình một bên là núi, một bên là biển. Chùa Linh Ứng là một quần thể gồm nhiều hạng mục khác nhau. Nơi đây được xem là cõi Phật giữa chốn trần gian.\n" +
//                "\n" +
//                "Được khởi công xây dựng từ tháng 07/2004 và khánh thành 07/2010, Chùa Linh Ứng Bãi Bụt Đà Nẵng đang ngày một trở thành điểm thu hút khá nhiều người ghé qua.\n"+
//                "\n" +
//                "Tại sao lại gọi là \"cõi Phật giữa chốn trần gian\"? Bởi vì Chùa Linh Ứng được xây dựng ở vị thế tựa lưng vào đỉnh Sơn Trà vững chãi, hướng mặt ra biển Đông bao la, phía hữu là ngọn Hải Vân ngăn che với dòng Hàn giang hiền hòa thơ mộng, xa xa là đảo Cù Lao Chàm. Nơi đây còn là nơi giao hòa giữa biển trời với núi sông, với tiếng vỗ rì rầm của biển cả.\n" +
//                "\n"+
//                "Nhưng đừng nhầm lẫn Chùa Linh Ứng Bãi Bụt với chùa nào khác vì Đà Nẵng có đến 3 ngôi Chùa Linh Ứng đấy. Trong đó, Chùa Linh Ứng Bãi Bụt được xem là ngôi chùa lớn nhất ở thành phố. Ngôi chùa này mang một phong cách hiện đại kết hợp với truyền thống vốn có của chùa chiền Việt Nam, nên nếu đến đây bạn sẽ thấy nó nổi bật lên hẳn", "Đà Nẵng" , "Hoàng Sa, Thọ Quang, Sơn Trà, Việt Nam, Đà Nẵng", 4.5, anh(R.drawable.anhchualinhung)
//        );
//
//        sqlDiaDiem.INSERT_DiaDiem("Bà Nà Hills", "Bà Nà Hill là khu resort cao cấp và giải trí phức hợp được xây dựng tại dãy Trường Sơn ở độ cao 1482m so với mặt nước biển. Đến với \"pháo đài\" trên núi này, du khách được thưởng ngoạn quang cảnh thiên nhiên hùng vĩ, núi rừng trùng điệp cùng các công trình kiến trúc mang phong cách châu Âu cổ kính. Không dừng ở đó, Bà Nà Hill sở hữu các hệ thống giải trí trong nhà hiện đại bậc nhất cùng các hệ thống nhà hàng Âu - Á sang trọng.\n" +
//                "\n" +
//                "Bà Nà Hill là khu resort cao cấp và giải trí phức hợp được xây dựng tại dãy Trường Sơn ở độ cao 1482m so với mặt nước biển. Đến với \"pháo đài\" trên núi này, du khách được thưởng ngoạn quang cảnh thiên nhiên hùng vĩ, núi rừng trùng điệp cùng các công trình kiến trúc mang phong cách châu Âu cổ kính. Không dừng ở đó, Bà Nà Hill sở hữu các hệ thống giải trí trong nhà hiện đại bậc nhất cùng các hệ thống nhà hàng Âu - Á sang trọng.\n"+
//                "\n" +
//                "Nói riêng về hệ thống cáp treo từ chân núi lên đến khu vực chính của Bà Nà Hills, hệ thống này hiện tại nắm giữ 2 kỉ lục thế giới gồm: cáp treo 1 dây dài nhất(khoảng 5042m), độ cao chênh lệch lớn nhất (khoảng 1290m). Cáp treo này có tốc độ di chuyển vừa phải, bạn có thể ngắm nhìn dãy Trường Sơn và một phần thành phố Đà Nẵng từ trên cao trong suốt 17 phút hành trình.\n" +
//                "\n"+
//                "Ngay tại khu du lịch Bà Nà Hills cũng có 1 chùa Linh Ứng. Sau khi xuống cáp treo sẽ có biển chỉ dẫn đường lên chùa Linh Ứng để dâng hương, quảng đường này khá xa đấy nhé! Đây là một trong 3 ngôi chùa Linh Ứng ở Đà Nẵng, có tượng Phật Thích Ca cao tới 27m, đế tượng được thiết kế 8 mặt thể hiện 8 giai đoạn trong cuộc đời Đức Phật. Chùa còn có bản sao của vườn Lộc uyển – nơi Phật thuyết giáo lần đầu tiên.", "Đà Nẵng" , "Trường Chinh, Hòa Thuận Tây, Tp. Đà Nẵng", 4.5, anh(R.drawable.anhbanlahills)
//        );
//
//        sqlDiaDiem.INSERT_DiaDiem("Ngũ Hành Sơn", "5 ngọn núi đá vôi khổng lồ: Kim Sơn, Mộc Sơn, Thủy Sơn, Hỏa Sơn và Thổ Sơn này nằm cách Đà Nẵng chỉ khoảng 8km, rất tiện cho khách du lịch thuê xe để tự trải nghiệm. Trước đây, theo lời kể của dân bản địa, núi Ngũ Hành Sơn đứng một mình giữa khoảng cát trắng vô tận của vùng bán đảo Tiên Sa. Theo tác động của thời gian và khí hậu biển, bên trong núi hình thành các hang đá lớn và có hình thù độc đáo; đá cẩm thạch ở đây cũng mang màu sắc 5 hành huyền ảo.\n" +
//                "\n" +
//                "5 ngọn núi đá vôi khổng lồ: Kim Sơn, Mộc Sơn, Thủy Sơn, Hỏa Sơn và Thổ Sơn này nằm cách Đà Nẵng chỉ khoảng 8km, rất tiện cho khách du lịch thuê xe để tự trải nghiệm.\n"+
//                "\n" +
//                "Trước đây, theo lời kể của dân bản địa, núi Ngũ Hành Sơn đứng một mình giữa khoảng cát trắng vô tận của vùng bán đảo Tiên Sa. Theo tác động của thời gian và khí hậu biển, bên trong núi hình thành các hang đá lớn và có hình thù độc đáo; đá cẩm thạch ở đây cũng mang màu sắc 5 hành huyền ảo.\n" +
//                "\n"+
//                "Nổi tiếng nhất trong 6 ngọn núi này (Hỏa Sơn gồm 2 ngọn tạo thành) có lẽ là Thủy Sơn, trên núi có nhiều đình chùa và công trình kì vĩ còn dưới chân núi này là làng nghề điêu khắc đá lâu năm - nơi lí tưởng để bạn mua quà lưu niệm.", "Đà Nẵng" , "Phường Hòa Hải, Quận Ngũ Hành Sơn, Tp. Đà Nẵng, Việt Nam", 4.5, anh(R.drawable.anhnguhanhdon)
//        );

    }

    public byte[] anh(int anh)
    {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),anh);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,50,stream);
        return stream.toByteArray();
    }
}