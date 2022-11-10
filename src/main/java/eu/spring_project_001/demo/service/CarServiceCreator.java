package eu.spring_project_001.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class CarServiceCreator
{
    private final CarServiceRepo serviceRepo;

    @EventListener(ApplicationStartedEvent.class)
    public void createCarService()
    {
        if (serviceRepo.getNumberOfCarService() == 0)
        {
            CarService service = new CarService();
            serviceRepo.save(service);
        }

    }
}
