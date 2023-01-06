package com.designfreed.galiasserverbackend.domain.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SyncView {
    private List<String> errores = new ArrayList<>();
    private List<String> sincronizados = new ArrayList<>();
    private Map<String, List<String>> advertencias = new HashMap<>();

    public SyncView() {
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }

    public List<String> getSincronizados() {
        return sincronizados;
    }

    public void setSincronizados(List<String> sincronizados) {
        this.sincronizados = sincronizados;
    }

    public Map<String, List<String>> getAdvertencias() {
        return advertencias;
    }

    public void setAdvertencias(Map<String, List<String>> advertencias) {
        this.advertencias = advertencias;
    }
}
