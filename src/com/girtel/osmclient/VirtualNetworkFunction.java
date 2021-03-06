package com.girtel.osmclient;

import com.girtel.osmclient.utils.OSMConstants;

import java.util.List;


public class VirtualNetworkFunction extends OSMComponent{


    private String id, name, description, status, nsIdRef;
    private VirtualNetworkFunctionDescriptor vnfd;
    private List<ConnectionPoint> connPointList;
    private List<MonitoringParameter> monParamList;
    private VirtualInfrastructureManager vim;
    private NetworkService ns;

    /**
     * Constructor
     * @param id VNF identifier
     * @param name VNF name
     * @param description VNF description
     * @param status VNF current status
     * @param nsIdRef NS identifier which this VNF belongs to
     * @param vnfd  VNFD which defines this VNF
     * @param connPointList VNF ConnectionPoint list
     * @param monParamList VNF MonitoringParameter list
     */
    protected VirtualNetworkFunction(String id, String name, String description, String status, String nsIdRef, VirtualNetworkFunctionDescriptor vnfd,
                                  List<ConnectionPoint> connPointList, List<MonitoringParameter> monParamList)
    {
        super(name, OSMConstants.OSMComponentType.VNF);
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.nsIdRef = nsIdRef;
        this.vnfd = vnfd;
        this.connPointList = connPointList;
        this.monParamList = monParamList;
    }

    /**
     * Gets VNF identifier
     * @return VNF identifier
     */
    public String getId()
    {
        return id;
    }

    /**
     * Gets VNF name
     * @return VNF name
     */
    public String getName()
    {
        return name;
    }


    /**
     * Gets VNF description
     * @return VNF description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Gets VNF current status
     * @return VNF current status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * Gets NS identifier which this VNF belongs to
     * @return NS identifier which this VNF belongs to
     */
    public String getNSID()
    {
        return nsIdRef;
    }

    /**
     * Gets NS which this VNF belongs to
     * @return NS
     */
    public NetworkService getNS()
    {
        return this.ns;
    }

    /**
     * Gets VIM where this VNF is instantiated
     * @return VIM
     */
    public VirtualInfrastructureManager getVIM()
    {
        return this.vim;
    }
    /**
     * Gets VNFD which defines this VNF
     * @return VNFD which defines this VNF
     */
    public VirtualNetworkFunctionDescriptor getVNFD()
    {
        return vnfd;
    }

    /**
     * Gets VFF connection-point list
     * @return VNF connection-point list
     */
    public List<ConnectionPoint> getConnectionPointList()
    {
        return connPointList;
    }

    /**
     * Gets monitoring parameter list
     * @return monitoring parameter list
     */
    public List<MonitoringParameter> getMonitoringParameterList()
    {
        return monParamList;
    }

}
