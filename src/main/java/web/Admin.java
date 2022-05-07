package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import dao.ComRepo;
import data.Commercant;
import data.User;

@Controller 
public class Admin {
	@RequestMapping(value = "/invite", method = RequestMethod.GET)
	public String invite(Model mdl) {
		return "admin/invite.html";
	}
	@RequestMapping(value = "/invite", method = RequestMethod.POST)
	public String saveInvite(ModelMap mdl,
			@RequestParam("nomCommercial") String nomCommercial,
			@RequestParam("adresse") String adresse,
			@RequestParam("ville") String ville,
			@RequestParam("cp") String cp,
			@RequestParam("email") String email,
			@RequestParam("tel") String tel,
			@RequestParam("siteweb") String siteweb,
			@RequestParam("facebook") String facebook,
			@RequestParam("instagram") String instagram,
			@RequestParam("open") String open,
			@RequestParam("close") String close
	) {
		boolean canSave = true;
		if(canSave) {
			Commercant c = new Commercant(nomCommercial,adresse,cp,ville,email,tel,siteweb,facebook,instagram,open,close);
			mdl.put("commercant", c);
			ComRepo.save(c);
			return "index.html";
		}else {
			return "admin/invite.html";
		}
	}
	@RequestMapping(value = "/adherant", method = RequestMethod.GET)
	public String adherant() {
		return "index.html";
	}
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public String stats(Model mdl) {
		User user = new User();
		user.setUsername("ROM");
		return "stats.jsp";
	}
	@RequestMapping(value = "/database", method = RequestMethod.GET)
	public String database() {
		return "index.html";
	}
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard() {
		return "dashboard.html";
	}

}