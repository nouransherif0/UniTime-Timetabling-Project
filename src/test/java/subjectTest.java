package org.unitime.timetable.events.org.unitime.timetable.events;

import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.unitime.timetable.events.ResourceLookupBackend;
import org.unitime.timetable.gwt.command.client.GwtRpcException;
import org.unitime.timetable.gwt.shared.EventInterface;
import org.unitime.timetable.model.Session;
import org.unitime.timetable.model.SubjectArea;
import org.unitime.timetable.model.dao.EventDAO;
import org.unitime.timetable.model.dao.SessionDAO;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SubjectTest {

    @Mock
    private org.hibernate.Session hibSession;

    @Mock
    private Query<SubjectArea> mockQuery;

    @Mock
    private Session academicSession;

    @InjectMocks
    private ResourceLookupBackend backend;

    @Test
    void testSubjectNotFound_throwsException() {
        Long sessionId = 1L;

        try (MockedStatic<SessionDAO> mockedSessionDAO = mockStatic(SessionDAO.class);
             MockedStatic<EventDAO> mockedEventDAO = mockStatic(EventDAO.class)) {  // <-- ADD THIS

            // Mock EventDAO so the method gets our hibSession mock
            EventDAO mockEventDAO = mock(EventDAO.class);
            mockedEventDAO.when(EventDAO::getInstance).thenReturn(mockEventDAO);
            when(mockEventDAO.getSession()).thenReturn(hibSession);  // <-- KEY FIX

            // Mock academicSession lookup
            SessionDAO mockSessionDAO = mock(SessionDAO.class);
            mockedSessionDAO.when(SessionDAO::getInstance).thenReturn(mockSessionDAO);
            when(mockSessionDAO.get(sessionId)).thenReturn(academicSession);

            // Mock the Hibernate query chain returning empty
            when(hibSession.createQuery(anyString(), eq(SubjectArea.class))).thenReturn(mockQuery);
            when(mockQuery.setParameter(anyString(), any())).thenReturn(mockQuery);
            when(mockQuery.list()).thenReturn(Collections.emptyList());

            GwtRpcException ex = assertThrows(GwtRpcException.class, () ->
                    backend.findResource(sessionId, EventInterface.ResourceType.SUBJECT, "test")
            );

            assertEquals("Unable to find a Subject named test.", ex.getMessage());
        }
    }
}