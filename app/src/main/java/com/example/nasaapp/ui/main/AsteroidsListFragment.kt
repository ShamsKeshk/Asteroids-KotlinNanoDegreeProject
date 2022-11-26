package com.example.nasaapp.ui.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.core.data.NearEarth
import com.example.nasaapp.R
import com.example.nasaapp.databinding.FragmentAsteroidsListBinding
import com.example.nasaapp.framwork.model.Result
import com.example.nasaapp.domain.viewmodel.AsteroidsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AsteroidsListFragment : Fragment(), OnAsteroidsItemClicked {

    private val asteroidsViewModel: AsteroidsViewModel by activityViewModels()

    private lateinit var asteroidsAdapter: HomeAsteroidsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = FragmentAsteroidsListBinding.inflate(inflater)

        asteroidsAdapter = HomeAsteroidsAdapter(this)
        binding.asteroidRecycler.adapter = asteroidsAdapter

        binding.lifecycleOwner = this
        binding.viewModel = asteroidsViewModel

        setHasOptionsMenu(true)


        binding.viewModel = asteroidsViewModel
        binding.lifecycleOwner = this


        asteroidsViewModel.asteroidsLiveDate().observe(viewLifecycleOwner) { result ->
            result.let {
                if (it.isSuccessful()){
                    asteroidsAdapter.submitList((it as Result.Success).data)
                }
            }
        }

        return binding.root
    }

    override fun onAsteroidClicked(nearEarth: NearEarth) {
        findNavController()
            .navigate(AsteroidsListFragmentDirections.actionAsteroidsListFragmentToDetailFragment(nearEarth.id))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(com.example.nasaapp.R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.show_all_menu -> {
                asteroidsViewModel.syncAsteroids(true)
                true
            }
            R.id.show_today_menu -> {
                asteroidsViewModel.syncTodayAsteroids()
                true
            }
            R.id.show_cached_menu -> {
                asteroidsViewModel.syncCachedAsteroids()
                true
            }
            else-> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}
