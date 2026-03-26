interface IData {
    void show(); // Mặc định là public abstract
}

class DataManager implements IData {
    // Cố tình KHÔNG ghi public
    public void show() { //Mặc định là package-private
        System.out.println("Show Data");
    }
}
/*
    Hiện tượng khi hàm show() không được khai báo là public:
        Lỗi khi compile: show() in DataManager cannot implement show() in IData
        Nguyên nhân: Đang gán một phương thức yếu hơn để implement một phương thức mạnh hơn.
        Giải thích: Khi implement interface/override method, access modifier phải ≥ access modifier của parent:
 */