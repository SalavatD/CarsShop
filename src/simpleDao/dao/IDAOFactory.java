package simpleDao.dao;

public interface IDAOFactory {

    ICarDAO getCarDAO();

    IClientDAO getClientDAO();

    IOrderDAO getOrderDAO();
}
