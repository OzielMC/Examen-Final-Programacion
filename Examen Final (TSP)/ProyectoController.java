@Controller
public class ProyectoController {
    
    @Value("${api.url}")
    private String apiUrl;
    private APIExternalService apiExternalService;

    public ProyectoController(APIExternalService apiExternalService) {
        this.apiExternalService = apiExternalService;
    }

    @GetMapping("/proyectos")
    public String obtenerProyectos(Model model) {
        Map<String, Proyecto> proyectos = apiExternalService.obtenerProyectos();
        model.addAttribute("proyectos", proyectos.values());
        return "proyectos";
    }
}