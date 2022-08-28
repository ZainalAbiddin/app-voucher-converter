class VoucherConverter {
    private int remainingPoint;
    private String message;
    private String redeemVoucher;
    public VoucherConverter(){
    }
    public VoucherConverter(int remainingPoint,String message,String redeemVoucher){
        this.remainingPoint =remainingPoint;
        this.message = message;
        this.redeemVoucher = redeemVoucher;
    }

    public String getRedeemVoucher() {
        return redeemVoucher;
    }

    public void setRedeemVoucher(String redeemVoucher) {
        this.redeemVoucher = redeemVoucher;
    }

    public int getRemainingPoint() {
        return remainingPoint;
    }

    public void setRemainingPoint(int remainingPoint) {
        this.remainingPoint = remainingPoint;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public VoucherConverter convertVoucher(int point){
        if(point >= 800){
            message = "Your point : "+point+"p can redeem up-to voucher 100.000";
            remainingPoint = point - 800;
            redeemVoucher = "100000";
        } else if (point >= 400) {
            message = "Your point : "+point+"p can redeem up-to voucher 50.000";
            remainingPoint = point - 400;
            redeemVoucher = "50000";
        } else if (point >= 200) {
            message = "Your point : "+point+"p can redeem up-to voucher 25.000";
            remainingPoint = point - 200;
            redeemVoucher = "25000";
        } else if (point >= 100) {
            message = "Your point : "+point+"p can redeem up-to voucher 10.000";
            remainingPoint = point - 100;
            redeemVoucher = "10000";
        } else {
            message = "Your point : "+point+"p can't redeem any voucher";
            remainingPoint = point;
            redeemVoucher = "";
        }

        return new VoucherConverter(remainingPoint,message,redeemVoucher);
    }
}
