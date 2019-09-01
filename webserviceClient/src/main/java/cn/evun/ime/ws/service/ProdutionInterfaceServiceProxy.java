package cn.evun.ime.ws.service;

public class ProdutionInterfaceServiceProxy implements cn.evun.ime.ws.service.ProdutionInterfaceService {
  private String _endpoint = null;
  private cn.evun.ime.ws.service.ProdutionInterfaceService produtionInterfaceService = null;
  
  public ProdutionInterfaceServiceProxy() {
    _initProdutionInterfaceServiceProxy();
  }
  
  public ProdutionInterfaceServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initProdutionInterfaceServiceProxy();
  }
  
  private void _initProdutionInterfaceServiceProxy() {
    try {
      produtionInterfaceService = (new cn.evun.ime.ws.service.impl.ProdutionInterfaceServiceImplServiceLocator()).getProdutionInterfaceServiceImplPort();
      if (produtionInterfaceService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)produtionInterfaceService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)produtionInterfaceService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (produtionInterfaceService != null)
      ((javax.xml.rpc.Stub)produtionInterfaceService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.evun.ime.ws.service.ProdutionInterfaceService getProdutionInterfaceService() {
    if (produtionInterfaceService == null)
      _initProdutionInterfaceServiceProxy();
    return produtionInterfaceService;
  }
  
  public java.lang.String MESJC02(java.lang.String content) throws java.rmi.RemoteException{
    if (produtionInterfaceService == null)
      _initProdutionInterfaceServiceProxy();
    return produtionInterfaceService.MESJC02(content);
  }
  
  public java.lang.String MESZP02(java.lang.String content) throws java.rmi.RemoteException{
    if (produtionInterfaceService == null)
      _initProdutionInterfaceServiceProxy();
    return produtionInterfaceService.MESZP02(content);
  }
  
  public java.lang.String MESCS01(java.lang.String content) throws java.rmi.RemoteException{
    if (produtionInterfaceService == null)
      _initProdutionInterfaceServiceProxy();
    return produtionInterfaceService.MESCS01(content);
  }
  
  
}