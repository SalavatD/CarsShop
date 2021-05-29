package simpleDao.dao;

public class DAOFactory implements IDAOFactory {

    private static IDAOFactory factory = null;

    private DAOFactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized IDAOFactory getInstance() {
        if (factory == null) {
            factory = new DAOFactory();
        }
        return factory;
    }

    @Override
    public ICarDAO getCarDAO() {
        return new CarDAO();
    }

    @Override
    public IClientDAO getClientDAO() {
        return new ClientDAO();
    }

    @Override
    public IOrderDAO getOrderDAO() {
        return new OrderDAO();
    }
}
