package hsvp.digital.allottee_corner.allinterface;


import java.util.List;

import hsvp.digital.allottee_corner.model.AlloteeHistoryResponse;
import hsvp.digital.allottee_corner.model.AllotteApplicationStatusResponse;

public interface allotteeAppStatusData_interface {

    void allotteeAppStatusdata(List<AllotteApplicationStatusResponse.Datum> data);

}
