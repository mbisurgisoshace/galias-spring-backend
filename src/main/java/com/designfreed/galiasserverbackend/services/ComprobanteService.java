package com.designfreed.galiasserverbackend.services;

import com.designfreed.galiasserverbackend.domain.view.ComprobanteItemView;
import com.designfreed.galiasserverbackend.domain.view.ComprobanteView;

import java.util.List;

public interface ComprobanteService {
    List<ComprobanteItemView> getComprobantes();
}
