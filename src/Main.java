import simpleDao.dao.*;

public class Main {

    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        ICarDAO carDAO = factory.getCarDAO();
        IClientDAO clientDAO = factory.getClientDAO();
        IOrderDAO orderDAO = factory.getOrderDAO();
    }
}
