package cn.evun.ime.ws.service;

public class AndonServiceProxy implements cn.evun.ime.ws.service.AndonService {
  private String _endpoint = null;
  private cn.evun.ime.ws.service.AndonService andonService = null;
  
  public AndonServiceProxy() {
    _initAndonServiceProxy();
  }
  
  public AndonServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAndonServiceProxy();
  }
  
  private void _initAndonServiceProxy() {
    try {
      andonService = (new cn.evun.ime.ws.service.impl.AndonServiceImplServiceLocator()).getAndonServiceImplPort();
      if (andonService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)andonService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)andonService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (andonService != null)
      ((javax.xml.rpc.Stub)andonService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.evun.ime.ws.service.AndonService getAndonService() {
    if (andonService == null)
      _initAndonServiceProxy();
    return andonService;
  }
  
  public java.lang.String MESZP05(java.lang.String content) throws java.rmi.RemoteException{
    if (andonService == null)
      _initAndonServiceProxy();
    return andonService.MESZP05(content);
  }
  
  public java.lang.String MESJC05(java.lang.String content) throws java.rmi.RemoteException{
    if (andonService == null)
      _initAndonServiceProxy();
    return andonService.MESJC05(content);
  }
  
  public java.lang.String MESCS04(java.lang.String content) throws java.rmi.RemoteException{
    if (andonService == null)
      _initAndonServiceProxy();
    return andonService.MESCS04(content);
  }
  
  
}