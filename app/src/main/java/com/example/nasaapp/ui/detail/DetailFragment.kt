package com.example.nasaapp.ui.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.nasaapp.R
import com.example.nasaapp.databinding.FragmentDetailBinding
import com.example.nasaapp.domain.viewmodel.AsteroidsViewModel
import com.example.nasaapp.framwork.model.getData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val asteroidsViewModel: AsteroidsViewModel by activityViewModels()

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val selectedAsteroidId = DetailFragmentArgs.fromBundle(requireArguments()).selectedAsteroidId

        asteroidsViewModel.syncSelectedNearEarthObject(selectedAsteroidId)

        binding.helpButton.setOnClickListener {
            displayAstronomicalUnitExplanationDialog()
        }

        inisSelectedNearEarthObserver()

        return binding.root
    }

    private fun inisSelectedNearEarthObserver(){
        asteroidsViewModel.getSelectedNearEarthLiveData().observe(viewLifecycleOwner , Observer {
            binding.asteroid = it.getData()
        })
    }

    private fun displayAstronomicalUnitExplanationDialog() {
        val builder = AlertDialog.Builder(requireActivity())
            .setMessage(getString(R.string.astronomica_unit_explanation))
            .setPositiveButton(android.R.string.ok, null)
        builder.create().show()
    }
}
