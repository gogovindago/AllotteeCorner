package hsvp.digital.allottee_corner.allinterface;


import java.util.List;

import hsvp.digital.allottee_corner.model.AllottePaymentReceived2Response;

public interface allottePaymentReceived2Data_interface {

    void allottePayment2data(List<AllottePaymentReceived2Response.Payment> data);

    void allottePaymentDetail2data(List<AllottePaymentReceived2Response.PaymentDetail> data);
}
