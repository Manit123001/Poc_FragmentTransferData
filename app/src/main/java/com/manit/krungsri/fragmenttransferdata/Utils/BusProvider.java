package com.manit.krungsri.fragmenttransferdata.Utils;

import com.squareup.otto.Bus;

/**
 * Created by MCNEWZ on 08-Dec-17.
 */

public class BusProvider {

    private static Bus bus = new Bus();

    public static Bus getInstance() {
        return bus;
    }
}
