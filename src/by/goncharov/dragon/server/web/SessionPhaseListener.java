package by.goncharov.dragon.server.web;

import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class SessionPhaseListener implements PhaseListener {

    private static final String SESSION_DENIED_PAGE = "/jsp/login.faces";

    @Override
    public void afterPhase(PhaseEvent event) {
        //Do nothing
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        // Session detection code goes here
        System.out.println(event.getPhaseId());
        FacesContext facesContext = event.getFacesContext();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);

        boolean newSession = (session == null) || (session.isNew());
        boolean postback = !externalContext.getRequestParameterMap().isEmpty();
        boolean timedout = postback && newSession;
        if (timedout) {
            Application app = facesContext.getApplication();
            ViewHandler viewHandler = app.getViewHandler();
            UIViewRoot view = viewHandler.createView(facesContext, SESSION_DENIED_PAGE);
            facesContext.setViewRoot(view);
            facesContext.renderResponse();
            try {
                viewHandler.renderView(facesContext, view);
                facesContext.responseComplete();
            } catch (Throwable t) {
                throw new FacesException("Session timed out", t);
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
