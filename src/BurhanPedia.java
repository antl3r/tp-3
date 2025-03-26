import repos.AdminRepository;
import repos.PromoRepository;
import repos.UserRepository;
import repos.VoucherRepository;

public class BurhanPedia {
    private UserRepository userRepo = new UserRepository();
    private VoucherRepository voucherRepo = new VoucherRepository();
    private PromoRepository promoRepo = new PromoRepository();
    private AdminRepository adminRepo = new AdminRepository();

    public UserRepository getUserRepo() {
        return userRepo;
    }

    public VoucherRepository getVoucherRepo() {
        return voucherRepo;
    }

    public PromoRepository getPromoRepo() {
        return promoRepo;
    }

    public AdminRepository getAdminRepo() {
        return adminRepo;
    }
}
